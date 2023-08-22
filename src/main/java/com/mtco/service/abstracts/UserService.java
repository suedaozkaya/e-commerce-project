package com.mtco.service.abstracts;

import java.util.List;

import com.mtco.domain.User;
import com.mtco.dto.request.RegisterRequest;
import com.mtco.dto.request.UpdateUserInfoRequest;
import com.mtco.dto.request.UpdatePasswordRequest;
import com.mtco.dto.response.UserResponseDTO;

public interface UserService {
	
	List<UserResponseDTO> getAllUsers();

	User getUserByEmail(String email);

	void saveUser(RegisterRequest registerRequest);

	UserResponseDTO getPrinciple();

	UserResponseDTO getUserById(Long id);

	void updatePassword(UpdatePasswordRequest updatePasswordRequest);

	void updateUser(UpdateUserInfoRequest updateInfoRequest);

	void removeUserById(Long id);

	User getCurrentUser();

}
