package com.corso.checkstring;

import java.util.List;

import com.corso.standardwords.AlgorithmType;
import com.corso.model.Match;
import com.corso.standardwords.StandardWords;
import com.corso.standardwords.StandardWordsFromDB;

public class MatchCheckString extends CheckString{

	private List<Match> matchlist;
	
	public MatchCheckString(CheckString next) {
		super(next);
		StandardWords sw = new StandardWordsFromDB();
		matchlist = sw.getMatch(); 	
	}
	
	public MatchCheckString() {
		super();
		StandardWords sw = new StandardWordsFromDB();
		matchlist = sw.getMatch();
	}
	
	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Match;
	}

	@Override
	protected String checkimpl(String input) {
		for(Match m : matchlist) {
			if(input.equals(m.getInput())) {
				return m.getStandardword();
			}
		}
		return null;
	}

}
