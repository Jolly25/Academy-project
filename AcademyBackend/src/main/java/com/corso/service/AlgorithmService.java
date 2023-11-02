package com.corso.service;

import java.util.List;

import com.corso.checkstring.AlgorithmType;
import com.corso.dao.AlgorithmDAO;
import com.corso.model.AlgoResult;
import com.corso.model.Algorithm;


public class AlgorithmService {

	private AlgorithmDAO dao;
	
	public List<AlgoResult> getAllAlgoResult() {
		return dao.getAllAlgoResult();
	}
	
	public Algorithm getAlgorithmByType(AlgorithmType type) {
		return dao.getAlgorithmByType(type);
	}
	
	public void setDao(AlgorithmDAO dao) {
		this.dao = dao;
	}
}
