package com.corso.checkstring;


import org.springframework.beans.factory.annotation.Autowired;

import com.corso.model.Algorithm;
import com.corso.model.Match;
import com.corso.service.MatchService;

public class MatchCheckString extends CheckString{

	@Autowired
	private MatchService matchService;
	
	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Match);
	}

	@Override
	protected String checkimpl(String input) {
		Match m = matchService.findByInput(input);
		if(!m.isConfirm()) { 
			matchService.removeMatch(m);
			m = null;
		}
		if(m==null) return null;
		if(m.getAlgorithm().getAlgorithm().equals(AlgorithmType.NotFound) || m.getStandardword()==null) return "";
		System.out.println(m.getStandardword());
		return m.getStandardword();
	}

}

