package com.corso.checkstring;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.model.AlgoResult;
import com.corso.service.AlgorithmService;

public class AlgorithmHandler {
	
	@Autowired
	private CheckString c1, c2, c3, c4, c5, c6, c7, c8;
	
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
		firstAlgo = getAlgorithmFromType(algos.get(0).type); 
		CheckString temp1 = firstAlgo;
		CheckString temp2 = null;
		for(int i = 1; i < algos.size() - 1; i++) {
			temp2 = getAlgorithmFromType(algos.get(i).type);
			temp1.setNext(temp2);
			temp1 = temp2;
		}
	}

	private CheckString getAlgorithmFromType(AlgorithmType type) {
		switch(type) {
		  case Contains:
		    	return new Contains();
		  case Contained:
		    	return new Contained();
		  case Equals:
		    	return new Equals();
		  case Match:
		    	return new MatchCheckString();
		  case Fisher:
		    	return new Fisher();
		  case Levenshtein1:
		    	return new Levenshtein1();
		  case Levenshtein2:
		    	return new Levenshtein2();
		  case Levenshtein3:
		    	return new Levenshtein3();
		  default:
		    	return null;
		}
	}
}
