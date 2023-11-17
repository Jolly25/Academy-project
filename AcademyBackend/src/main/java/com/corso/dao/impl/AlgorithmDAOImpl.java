package com.corso.dao.impl;

import java.util.List;
import com.corso.checkstring.AlgorithmType;
import com.corso.dao.AlgorithmDAO;
import com.corso.model.AlgoResult;
import com.corso.model.Algorithm;

public class AlgorithmDAOImpl extends BaseDAOImpl implements AlgorithmDAO{
	
	@SuppressWarnings("unchecked")
	public List<AlgoResult> getAllAlgoResult() {
		return (List<AlgoResult>) super.all(AlgoResult.class);
	}
	
	public Algorithm getAlgorithmByType(AlgorithmType type) {
		return (Algorithm) super.findOneByAttribute(Algorithm.class, "Nome", type.toString());
	}
	
	public void updateAlgoResult(List<AlgoResult> results) {
		for(AlgoResult r : results) {
			super.update(r);
		}
	}

}
