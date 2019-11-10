package com.networkproject.repository;

import java.util.List;

import com.networkproject.model.user.User;

public interface UserRepository {

	User saveUser(User user);
	
	User updateUser(User user);
	
	User deleteUser(User user);
	
	List<User> findAllUsers();
	
	User findUserById(int userId);
	
	User findUserByUserName(String userName);
	
	Integer findUserIdByUserName(String userName);
	
	User findUserByTextId(int textId);
	
	Boolean findUserByUsernameAndPassword(String userName, String password);
	
	List<String> findAllUserNames();
	
}
