package com.mtco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtco.dto.request.UpdatePasswordRequest;
import com.mtco.dto.request.UpdateUserInfoRequest;
import com.mtco.dto.response.UserResponseDTO;
import com.mtco.dto.response.VRResponse;
import com.mtco.service.abstracts.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;
	
	@GetMapping("/auth/all")
	@PreAuthorize("hasRole('ADMIN')") // hasRole default role_ ekliyor: ROLE_ADMIN
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
		List<UserResponseDTO> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	// TODO getAll da daha sonra paging denicem
	
	
	// sisteme giren kullanici bilgileri 
	// parametre almamasinin sebebi kullanici security contextde var
	@GetMapping("account/info")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<UserResponseDTO> getUserInfo(){
		UserResponseDTO userDTO = userService.getPrinciple();
		return ResponseEntity.ok(userDTO);
	}
	
	
	@GetMapping("/{id}/auth")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
		UserResponseDTO userDTO = userService.getUserById(id);
		return ResponseEntity.ok(userDTO);
	}
	
	
	@PatchMapping("account/password")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> updatePassword(@Valid @RequestBody UpdatePasswordRequest updatePasswordRequest){
		userService.updatePassword(updatePasswordRequest);
		
		VRResponse response = new VRResponse();
	
		response.setMessage("Password updated successfully.");
		response.setSuccess(true);
		return ResponseEntity.ok(response);
		
	}
	
	
	@PatchMapping("/account/info")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	public ResponseEntity<VRResponse> updateUserInfo(@Valid @RequestBody UpdateUserInfoRequest updateUserInfoRequest){
		userService.updateUser(updateUserInfoRequest);
		
		VRResponse response = new VRResponse();
		
		response.setMessage("User updated successfully.");
		response.setSuccess(true);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}/auth")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VRResponse> deleteUserById(@PathVariable Long id){
		
		userService.removeUserById(id);
		
		VRResponse response = new VRResponse();
		response.setMessage("User deleted successfully.");
		response.setSuccess(true);
		
		return ResponseEntity.ok(response);
		
	}
	

	

}
