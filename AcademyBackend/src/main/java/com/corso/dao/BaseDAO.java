package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.corso.model.AlgoResult;


public /*abstract*/ class BaseDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager manager = entityManagerFactory.createEntityManager();

	public Object findOneByAttribute(Class c, String attribute, String value) {
		try {
			Object o = manager.createQuery("SELECT t FROM " + c.getName() + " t where " + attribute + " = :value1")
					.setParameter("value1", value).getSingleResult();
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public List<?> findAllByAttribute(Class c, String attribute, String value) {
		try {
			List<?> l = manager.createQuery("SELECT t FROM " + c.getName() + " t where " + attribute + " = :value1")
					.setParameter("value1", value).getResultList();
			return l;
		}
		catch (Exception e) {
			return null;
		}
	}

	public  List<?> all(Class c) {
		String jpql = "from " + c.getSimpleName();  
		Query q =  manager.createQuery(jpql,c);
		@SuppressWarnings("unchecked")
		List<?> l = q.getResultList();
		return l;
	}

	public Object find(Class c, Integer id) {
		try {
			Object o = manager.find(c, id);
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	public Object find(Class c, String id) {
		try {
			Object o = manager.find(c, id);
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public void update(Object o) {
		try {
			manager.getTransaction().begin();
			manager.merge(o);
			manager.getTransaction().commit();
		}
		catch (Exception e) {}
	}
	
	@Transactional
	public Object create(Object o) {
		try {
			manager.getTransaction().begin();
			manager.persist(o);
			manager.getTransaction().commit();
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

}
