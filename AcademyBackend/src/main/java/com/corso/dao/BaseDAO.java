package com.corso.dao;

import java.util.List;

public interface BaseDAO {

	public void update(BeanDTO o);
	
	@SuppressWarnings("rawtypes")
	public Object findOneByAttribute(Class c, String attribute, String value);
	
	@SuppressWarnings("rawtypes")
	public List<?> findAllByAttribute(Class c, String attribute, String value);
	
	@SuppressWarnings("rawtypes")
	public List<?> findAllByAttributeInt(Class c, String attribute, int value);

	@SuppressWarnings("rawtypes")
	public  List<?> all(Class c);

	@SuppressWarnings("rawtypes")
	public Object find(Class c, Integer id);

	@SuppressWarnings("rawtypes")
	public Object find(Class c, String id);

	public BeanDTO create(BeanDTO o);
	
	public void remove(BeanDTO o);
}
