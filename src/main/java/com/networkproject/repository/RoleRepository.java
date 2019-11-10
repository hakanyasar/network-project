package com.networkproject.repository;

import com.networkproject.model.user.Role;

public interface RoleRepository {

	Role saveRole (Role role);
	
	Role updateRole(Role role);
	
	Role deleteRole(Role role);
	
	Role findRoleById(int roleId);
	
	Role findRoleByUserId(int userId);
	
}
