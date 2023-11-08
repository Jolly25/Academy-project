package com.corso.standardwords;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.corso.model.Match;
import com.corso.service.MatchService;

public class StandardWordsFromTxt implements StandardWords{
	
	public StandardWordsFromTxt(String location) {
	}

	@Override
	public Set<String> getStandardWords() {
		//read file using filelocation
		Set<String> words = new HashSet<String>();
		words.add("Italy");
		words.add("South Korea");
		words.add("Philippines");
		words.add("Republic of Ireland");
		return words;
	}

	@Override
	public List<Match> getMatch() {
		MatchService service = new MatchService();
		return service.getAllMatches();
	}

}
