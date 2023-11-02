package com.corso.checkstring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.model.Match;
import com.corso.service.MatchService;
import com.corso.standardwords.StandardWords;

public class MatchCheckString extends CheckString{

	private List<Match> matchlist;
	
	@Autowired
	private StandardWords sw;
	
	@Autowired
	private MatchService matchService;
	
	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Match;
	}

	@Override
	protected String checkimpl(String input) {
		Match m = matchService.findByInput(input);
		if(m==null) return null;
		return m.getStandardword();
	}

}

