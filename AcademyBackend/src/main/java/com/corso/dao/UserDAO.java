package com.corso.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;
import com.corso.model.User;

public class UserDAO extends BaseDAO{
	
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
