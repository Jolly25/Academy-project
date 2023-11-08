package com.corso.service;

import com.corso.dao.UserDAO;
import com.corso.model.User;

public class UserService {

	private UserDAO dao;

	public User create(User user) {
		return dao.create(user);
	}
	
	public void setDao(UserDAO userDAO) {
		this.dao = userDAO;
	}
	
	public User find(Integer id) {
		return dao.find(id);
	}
	
	public User findByUsername(String username){
		return dao.findByUsername(username);
	}
	
	public boolean userExists(String username) {
		if(findByUsername(username) != null) return true;
		return false;
	}
}
