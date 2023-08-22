package com.mtco.service.abstracts;

import com.mtco.domain.Role;
import com.mtco.domain.enums.RoleType;

public interface RoleService {
	
	public Role findByRoleType(RoleType roleType);
	
	
}
