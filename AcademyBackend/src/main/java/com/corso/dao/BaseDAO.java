package com.corso.dao;

import java.util.List;

public interface BaseDAO {

	public void update(BeanDTO o);
	
	public Object findOneByAttribute(Class c, String attribute, String value);
	
	public List<?> findAllByAttribute(Class c, String attribute, String value);
	
	public List<?> findAllByAttributeInt(Class c, String attribute, int value);

	public  List<?> all(Class c);

	public Object find(Class c, Integer id);

	public Object find(Class c, String id);

	public BeanDTO create(BeanDTO o);
	
	public void remove(BeanDTO o);
}
