package com.corso.dao;

import java.util.List;
import com.corso.checkstring.AlgorithmType;
import com.corso.model.AlgoResult;
import com.corso.model.Algorithm;

public class AlgorithmDAO extends BaseDAO{
	
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
