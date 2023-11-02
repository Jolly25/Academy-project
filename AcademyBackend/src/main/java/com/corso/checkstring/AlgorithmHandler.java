package com.corso.checkstring;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.model.AlgoResult;
import com.corso.service.AlgorithmService;

public class AlgorithmHandler{
	
	@Autowired
	private CheckString matchCS, containsCS, containedCS, levenshtein1CS, levenshtein2CS, levenshtein3CS, fisherCS, equalsCS;
	
	@Autowired
	private AlgorithmService service;
	
	private CheckString firstAlgo;

	public CheckString buildCheckString() {
		if (firstAlgo == null) {
			updateFirstAlgo();
		}
		return firstAlgo;
	}

	private void updateFirstAlgo() {
		List<AlgoResult> algos = service.getAllAlgoResult(); 
		Collections.sort(algos);
		firstAlgo = getAlgorithmFromType(AlgorithmType.Match); 
		CheckString temp1 = firstAlgo;
		CheckString temp2 = null;
		for(int i = 0; i < algos.size(); i++) {
			temp2 = getAlgorithmFromType(algos.get(i).getAlgorithm().getAlgorithm());
			temp1.setNext(temp2);
			temp1 = temp2;
		}
	}

	private CheckString getAlgorithmFromType(AlgorithmType type) {
		switch(type) {
		  case Contains:
		    	return containsCS;
		  case Contained:
		    	return containedCS;
		  case Equals:
		    	return equalsCS;
		  case Match:
		    	return matchCS;
		  case Fisher:
		    	return fisherCS;
		  case Levenshtein1:
		    	return levenshtein1CS;
		  case Levenshtein2:
		    	return levenshtein2CS;
		  case Levenshtein3:
		    	return levenshtein3CS;
		  default:
		    	return null;
		}
	}
}
