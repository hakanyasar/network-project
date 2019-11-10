package com.networkproject.queries;

public class RoleQueries {

	public static final String findRoleById = "SELECT ro FROM Role ro WHERE ro.roleId = :roleId";
	
	public static final String findRoleByUserId = "SELECT ro FROM Role ro LEFT JOIN ro.users u WHERE u.userId = :userId";
	
}
