package com.corso.dao;

import java.util.List;

import com.corso.model.StandardWord;

public interface StandardWordDAO extends BaseDAO{
	
	public List<StandardWord> findAllSW();
	
	public List<StandardWord> findAllSWByDifficult(int dif);
	
	public StandardWord findByCommon(String common);
}
