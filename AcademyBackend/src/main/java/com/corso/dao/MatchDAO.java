package com.corso.dao;

import java.util.List;
import com.corso.model.Match;

public class MatchDAO extends BaseDAO{
	
	public void create(Match match){
		super.create(match);
	}

	public Match find(Integer id){
		return (Match) super.find(Match.class, id);
	} 
	
	public Match findByInput(String input) {
		return (Match) super.findOneByAttribute(Match.class, "Input", input);
	}

	public int countMatches(String algorithm) {
	    return super.findAllByAttribute(Match.class, "IdAlgoritmo", algorithm).size();
	    
	}
	
	@SuppressWarnings("unchecked")
	public List<Match> getAllMatches() {
		return (List<Match>) super.all(Match.class);
	}

}
