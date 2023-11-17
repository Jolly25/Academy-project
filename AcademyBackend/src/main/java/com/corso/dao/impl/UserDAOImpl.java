package com.corso.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

import com.corso.dao.UserDAO;
import com.corso.model.User;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager manager = entityManagerFactory.createEntityManager();
	
	@Transactional
	public User create(User user){
		return (User) super.create(user);
	}

	public User find(Integer id){
		return (User) super.find(User.class, id);
	} 

	public User findByUsername(String username) {
		return (User) super.findOneByAttribute(User.class, "Username", username);
	}
	
}
