package com.corso.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.corso.checkstring.AlgorithmType;
import com.corso.model.Algorithm;
import com.corso.model.Match;
import com.corso.service.AlgorithmService;

public class MatchDAO extends BaseDAO<Match>{
	
	@Autowired
	private AlgorithmService algorithmService;
	
	public void create(Match match){
		super.create(match);
	}
	
	public void remove(Match match) {
		super.remove(match);
	}

	public Match find(Integer id){
		return (Match) super.find(Match.class, id);
	} 
	
	public Match findByInput(String input) {
		return (Match) super.findOneByAttribute(Match.class, "Input", input);
	}

	public int countMatches(AlgorithmType type) {
		Algorithm algorithm = algorithmService.getAlgorithmByType(type);
	    return super.findAllByAttribute(Match.class, "IdAlgoritmo", "" + algorithm.getId()).size();
	}
	
	@SuppressWarnings("unchecked")
	public List<Match> getAllMatches() {
		return (List<Match>) super.all(Match.class);
	}

}
