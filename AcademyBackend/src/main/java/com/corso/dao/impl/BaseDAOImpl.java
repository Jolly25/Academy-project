package com.corso.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import com.corso.dao.BaseDAO;
import com.corso.dao.BeanDTO;


public abstract class BaseDAOImpl implements BaseDAO{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager manager = entityManagerFactory.createEntityManager();
	
	@Transactional
	public void update(BeanDTO o) {
		try {
			manager.getTransaction().begin();
			manager.merge(o);
			manager.getTransaction().commit();
		}
		catch (Exception e) {}
	}
	

	@SuppressWarnings("rawtypes")
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
	
	@SuppressWarnings("rawtypes")
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
	
	@SuppressWarnings("rawtypes")
	public List<?> findAllByAttributeInt(Class c, String attribute, int value) {
		try {
			List<?> l = manager.createQuery("SELECT t FROM " + c.getName() + " t where " + attribute + " = :value1")
					.setParameter("value1", value).getResultList();
			return l;
		}
		catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  List<?> all(Class c) {
		String jpql = "from " + c.getSimpleName();  
		Query q =  manager.createQuery(jpql,c);
		List<?> l = q.getResultList();
		return l;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object find(Class c, Integer id) {
		try {
			Object o = manager.find(c, id);
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	public BeanDTO create(BeanDTO o) {
		try {
			manager.getTransaction().begin();
			manager.persist(o);
			manager.flush();
			manager.getTransaction().commit();
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Transactional
	public void remove(BeanDTO o) {
		try {
			manager.getTransaction().begin();
			manager.remove(o);
			manager.getTransaction().commit();
		}
		catch (Exception e) {
		}
	}
	

}
