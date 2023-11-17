package com.corso.dao;

import com.corso.model.User;

public interface UserDAO extends BaseDAO{
	
	public User create(User user);

	public User find(Integer id);

	public User findByUsername(String username);
	
}
