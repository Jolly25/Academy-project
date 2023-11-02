package com.corso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

import com.corso.model.Match;
import com.corso.model.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class UserDAO extends BaseDAO{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();

	@Transactional
	public User create(User user){
		try {
			em.getTransaction().begin();
			em.persist(user);
			return user;
		}
		catch (Exception e){
			em.getTransaction().commit();
			return null;
		}

	}

	public User find(Integer id){
		return (User) em.find(User.class, id);
	} 

	public User findByUsername(String username) {
		return (User) super.findByAttribute(User.class, "Username", username);
	}
}
