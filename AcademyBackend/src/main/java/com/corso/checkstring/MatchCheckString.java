package com.corso.checkstring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.standardwords.AlgorithmType;
import com.corso.model.Match;
import com.corso.standardwords.StandardWords;

public class MatchCheckString extends CheckString{

	private List<Match> matchlist;
	
	@Autowired
	private StandardWords sw;
	
	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Match;
	}

	@Override
	protected String checkimpl(String input) {
		matchlist = sw.getMatch();
		for(Match m : matchlist) {
			if(input.equals(m.getInput())) {
				return m.getStandardword();
			}
		}
		return null;
	}

}

