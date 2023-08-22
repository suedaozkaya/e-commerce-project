package com.mtco.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mtco.domain.User;
import com.mtco.dto.response.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponseDTO userToUserDTO(User user);
	
	List<UserResponseDTO> map(List<User> userList);
	
}
