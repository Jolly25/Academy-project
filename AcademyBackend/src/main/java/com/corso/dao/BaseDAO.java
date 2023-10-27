package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




public /*abstract*/ class BaseDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	
	public  List<?> all(Class c) {
		String jpql = "from " + c.getClass().getSimpleName();  
	    Query q =  manager.createQuery(jpql,c);
		@SuppressWarnings("unchecked")
		List<?> l = q.getResultList();
		return l;
	}

	
	public Object find(Class c, Integer id) {
		Object o = manager.find(c, id);
		return o;
	}
	
	public Object find(Class c, String id) {
		Object o = manager.find(c, id);
		return o;
	}
	
}
