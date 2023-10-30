package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.corso.model.StandardWord;

public class StandardWordDAO{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	public List<StandardWord> findAllSW() {
		String jpql = "from StandardWord";  
	    Query q =  em.createQuery(jpql, StandardWord.class);

	    List<StandardWord> list = q.getResultList();
		
	    return list;
		
	}

}
