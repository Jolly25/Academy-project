package com.corso.dao;

import java.util.List;

import com.corso.checkstring.AlgorithmType;
import com.corso.model.AlgoResult;
import com.corso.model.Algorithm;

public interface AlgorithmDAO extends BaseDAO{
	
	public List<AlgoResult> getAllAlgoResult();
	
	public Algorithm getAlgorithmByType(AlgorithmType type);
	
	public void updateAlgoResult(List<AlgoResult> results);
}
