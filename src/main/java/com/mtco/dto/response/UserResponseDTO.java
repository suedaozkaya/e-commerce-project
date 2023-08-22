package com.mtco.dto.response;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.mtco.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

	private Long id;

	private String name;
	
	private String email;
	
	private String phoneNumber;
	
	private String password;
	
	private LocalDate createdAt;
	
	private Boolean builtIn;

	private Set<String> roles;
	
	public void setRoles(Set<Role> roles) {
		Set<String> roleStr = new HashSet<>();
		roles.forEach(r-> roleStr.add(r.getRoleType().getName()));
		this.roles = roleStr;
	}
}
