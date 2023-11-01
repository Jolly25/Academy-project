package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public /*abstract*/ class BaseDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager manager = entityManagerFactory.createEntityManager();

	public Object findByAttribute(Class c, String attribute, String value) {
		try {
			Object o = manager.createQuery("SELECT t FROM " + c.getName() + " t where " + attribute + " = :value1")
					.setParameter("value1", value).getSingleResult();
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

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
