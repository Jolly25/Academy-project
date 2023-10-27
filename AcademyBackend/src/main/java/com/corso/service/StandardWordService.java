package com.corso.service;

import java.util.List;

import com.corso.dao.StandardWordDAO;
import com.corso.model.StandardWord;

public class StandardWordService {
	
	private StandardWordDAO dao;
	
	public List<StandardWord> findAll() {
		return dao.findAllSW();
	}
	
	public void setDao(StandardWordDAO dao) {
		this.dao = dao;
	}
}
