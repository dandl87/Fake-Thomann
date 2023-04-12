package com.protom.fakethomann.model.dao;

import com.protom.fakethomann.model.entity.User;

public interface UserDAO {
	
	boolean createUser(User user);
	User readUser(String username);
	boolean updateUser(User user);
	boolean deleteUser(String username);
	
	//ArrayList<User> readAllUsers();

}
