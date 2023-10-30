package com.corso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

import com.corso.model.Match;
import com.corso.model.User;

public class UserDAO extends BaseDAO{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	@Transactional
	public void create(User user){
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public User find(Integer id){
		return (User) em.find(User.class, id);
	} 
	
	public User findByUsername(String username) {
		return (User) super.findByAttribute(User.class, "Username", username);
	}
}
