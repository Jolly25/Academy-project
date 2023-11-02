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
		
		
		c1.setNext(c2);
		c2.setNext(c3);
		c3.setNext(c4);
		c4.setNext(c5);
		c5.setNext(c6);
		c6.setNext(c7);
		c7.setNext(c8);
		
		firstAlgo = c1;
	}
}
