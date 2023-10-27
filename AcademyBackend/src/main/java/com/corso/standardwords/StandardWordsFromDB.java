package com.corso.standardwords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.corso.model.Match;
import com.corso.model.StandardWord;
import com.corso.service.MatchService;
import com.corso.service.StandardWordService;

public class StandardWordsFromDB implements StandardWords{

	@Override
	public Set<String> getStandardWords() {
		StandardWordService service = new StandardWordService();
		Set<String> set = new HashSet<String>();
		for(StandardWord sw : service.findAll()) {
			set.add(sw.getValue());
		}
		return set;
	}

	@Override
	public List<Match> getMatch() {
		MatchService service = new MatchService();
		return service.getAllMatches();
	}
	
}
