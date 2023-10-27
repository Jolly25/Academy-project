package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.corso.model.StandardWord;

public class StandardWordDAO{
	
	@PersistenceContext
	EntityManager em;

	public List<StandardWord> findAllSW() {
		String jpql = "from StandardWord";  
	    Query q =  em.createQuery(jpql, StandardWord.class);

	    List<StandardWord> list = q.getResultList();
		
	    return list;
		
	}

}
