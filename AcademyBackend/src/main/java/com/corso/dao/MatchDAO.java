package com.corso.dao;

import java.util.List;

import com.corso.checkstring.AlgorithmType;
import com.corso.model.Match;

public interface MatchDAO extends BaseDAO{
	
	public void create(Match match);
	
	public void remove(Match match);

	public Match find(Integer id);
	
	public Match findByInput(String input);

	public int countMatches(AlgorithmType type);

	public List<Match> getAllMatches();
	
}
