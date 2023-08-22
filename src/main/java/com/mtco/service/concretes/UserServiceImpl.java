package com.mtco.service.concretes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mtco.domain.Role;
import com.mtco.domain.User;
import com.mtco.domain.enums.RoleType;
import com.mtco.dto.request.RegisterRequest;
import com.mtco.dto.request.UpdatePasswordRequest;
import com.mtco.dto.request.UpdateUserInfoRequest;
import com.mtco.dto.response.UserResponseDTO;
import com.mtco.exception.BadRequestException;
import com.mtco.exception.ConflictException;
import com.mtco.exception.ResourceNotFoundException;
import com.mtco.mapper.UserMapper;
import com.mtco.repository.UserRepository;
import com.mtco.security.SecurityUtils;
import com.mtco.service.abstracts.RoleService;
import com.mtco.service.abstracts.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private RoleService roleService;
	
	private UserMapper userMapper;
	
	private PasswordEncoder passwordEncoder;

	// password encoder dan kaynaklı hata aldım:
	// The dependencies of some of the beans in the application context form a cycle:
	// constructor injectonda password encoderi lazy cagirmak gerekiyormus
	public UserServiceImpl(UserRepository userRepository, RoleService roleService, UserMapper userMapper,
		@Lazy PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	// securityde UserDetailsService de kullanılacak
	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email).
				orElseThrow(() -> new ResourceNotFoundException("No customer exists with email: " + email));
		
		return user;
	}

	@Override
	public void saveUser(RegisterRequest registerRequest) {
		if(userRepository.existsByEmail(registerRequest.getEmail())) {
			throw new ConflictException("Email already exists!");
		}
		
		Role role = roleService.findByRoleType(RoleType.ROLE_CUSTOMER);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		
		String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(encodedPassword);
		user.setPhoneNumber(registerRequest.getPhoneNumber());
		user.setRoles(roles);
		
		userRepository.save(user);
		
	}

	// **************************************
	
	@Override
	public List<UserResponseDTO> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserResponseDTO> userDTOList = userMapper.map(userList);
		return userDTOList;
	}

	// login olan kullanicinin bilgilerini gostermek icin
	@Override
	public UserResponseDTO getPrinciple() {
		User currentUser = getCurrentUser();
		UserResponseDTO userDTO = userMapper.userToUserDTO(currentUser);
		return userDTO;
	}
	
	@Override
	public User getCurrentUser() {
		String email = SecurityUtils.getCurrentUserLogin().orElseThrow(()->
		new ResourceNotFoundException("User not found."));
		
		User user = getUserByEmail(email);
		return user;
	}

	@Override
	public UserResponseDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("User not found.")); 
		return userMapper.userToUserDTO(user);
	}

	@Override
	public void updatePassword(UpdatePasswordRequest updatePasswordRequest) {
		User user = getCurrentUser();
		// built in user mi kontrol
		if(user.getBuiltIn()) {
			throw new BadRequestException("No permission to change this data.");
		}
		// old password kontrol
		if (!passwordEncoder.matches(updatePasswordRequest.getOldPassword(), user.getPassword())) {
			throw new BadRequestException("Old password did not match.");
		}
		// new password encode
		String encodedPassword = passwordEncoder.encode(updatePasswordRequest.getNewPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		
	}

	@Override
	public void updateUser(UpdateUserInfoRequest updateUserInfoRequest) {
		User user = getCurrentUser();
		
		if(user.getBuiltIn()) {
			throw new BadRequestException("No permission to change this data.");
		}
		
		boolean emailExists = userRepository.existsByEmail(updateUserInfoRequest.getEmail());
		if(emailExists && !user.getEmail().equals(updateUserInfoRequest.getEmail())) {
			throw new ConflictException("Email is already in use.");
		}
		
		user.setName(updateUserInfoRequest.getName());
		user.setEmail(updateUserInfoRequest.getEmail());
		user.setPhoneNumber(updateUserInfoRequest.getPhoneNumber());
		
		userRepository.save(user);
		
	}

	@Override
	public void removeUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("User not found.")); 
		
		if(user.getBuiltIn()) {
			throw new BadRequestException("Not permission to delete this data.");
		}
		
		userRepository.deleteById(user.getId());
		
	}

	
	
	
	
	
}
