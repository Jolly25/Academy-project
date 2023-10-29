package com.corso.standardwords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.model.Match;
import com.corso.model.StandardWord;
import com.corso.service.MatchService;
import com.corso.service.StandardWordService;

public class StandardWordsFromDB implements StandardWords{
	
	@Autowired
	MatchService matchService;
	
	@Autowired
	StandardWordService swService;

	@Override
	public Set<String> getStandardWords() {
		Set<String> set = new HashSet<String>();
		for(StandardWord sw : swService.findAll()) {
			set.add(sw.getValue());
		}
		return set;
	}

	@Override
	public List<Match> getMatch() {
		return matchService.getAllMatches();
	}
	
}

