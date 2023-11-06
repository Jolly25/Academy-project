package com.corso.service;

import com.corso.checkstring.AlgorithmType;
import com.corso.dao.MatchDAO;
import com.corso.model.Algorithm;
import com.corso.model.Match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MatchService {
	
	private MatchDAO dao;
	
	@Autowired
	private AlgorithmService algorithmService;
	
	public void create(Match match) {
		dao.create(match); 
		System.out.println("Creata occorrenza con id " + match.getId());
	} 
	
	public Match find(int id) {
		return dao.find(id);
	}
	
	public Match findByInput(String input) {
		return dao.findByInput(input);
	}
	
	public int countMatches(String algorithm) {
		return dao.countMatches(algorithm);
	}
	
	public List<Match> getAllMatches() {
		return dao.getAllMatches();
	}
	
	public List<Match> getAllCheckedAndFoundMatches() {
		List<Match> allmatches = dao.getAllMatches();
		List<Match> matches = new ArrayList<Match>();
		for(Match m : allmatches) {
			if(m.isConfirm() && m.getStandardword()!=null) matches.add(m);
		}
		return matches;
	}
	
	public List<Match> getAllUncheckedMatches() {
		List<Match> allmatches = dao.getAllMatches();
		List<Match> matches = new ArrayList<Match>();
		for(Match m : allmatches) {
			if(!m.isConfirm()) matches.add(m);
		}
		return matches;
	} 
	
	public void checkMatch(Match m) {
		m = findByInput(m.getInput());
		m.setConfirm(true);
		dao.update(m);
	}
	
	public void setMatchByAdmin(String input, String standardword) {
		Match m = findByInput(input);
		if(m==null) {
			m = new Match();
			m.setInput(input);
		}
		m.setStandardword(standardword);
		m.setAlgorithm(algorithmService.getAlgorithmByType(AlgorithmType.Admin));
		m.setConfirm(true);
		dao.update(m);
	}
	
	public void setDao(MatchDAO dao) {
		this.dao = dao;
	}
	
}
