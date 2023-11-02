package com.corso.service;

import java.util.List;

import com.corso.dao.AlgorithmDAO;
import com.corso.model.AlgoResult;


public class AlgorithmService {

	private AlgorithmDAO dao;
	
	public List<AlgoResult> getAllAlgoResult() {
		return dao.getAllAlgoResult();
	}
	
	public void setDao(AlgorithmDAO dao) {
		this.dao = dao;
	}
}
