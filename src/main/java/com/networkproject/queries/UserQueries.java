package com.networkproject.queries;

public class UserQueries {

	public static final String findAllUsers = "Select us FROM User us"; // +
	
	public static final String findAllUserNames = "Select us.userName FROM User us"; // +
	
	public static final String findUserById = "Select us FROM User us WHERE us.userId = :userId"; // +
	
	public static final String findUserByUserName = "Select us FROM User us WHERE us.userName = :userName"; // +
	
	public static final String findUserIdByUserName = "Select us.userId FROM User us WHERE us.userName = :userName";
	
	public static final String findUserByTextId = "Select us FROM User us LEFT JOIN us.texts t WHERE t.textId = :textId";
	
	public static final String findUserByUsernameAndPassword = "Select us FROM User us WHERE us.userName = :userName and us.password = :password";
	
	
	//public static final String findUserNameTextAddDateUpdateDateByUserId = "Select us.userName, t.text, t.addDate, t.updateDate FROM User us LEFT JOIN us.texts t WHERE us.userId = :userId";
	
	
	
	
}
