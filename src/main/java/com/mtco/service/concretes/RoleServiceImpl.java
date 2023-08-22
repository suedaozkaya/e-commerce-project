package com.mtco.service.concretes;

import org.springframework.stereotype.Service;

import com.mtco.domain.Role;
import com.mtco.domain.enums.RoleType;
import com.mtco.exception.ResourceNotFoundException;
import com.mtco.repository.RoleRepository;
import com.mtco.service.abstracts.RoleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	
	@Override
	public Role findByRoleType(RoleType roleType) {
		return roleRepository.findByRoleType(roleType).
				orElseThrow(()->new ResourceNotFoundException("Role" + roleType.getName() + " not found."));
	}
}
