package com.corso.service;

import com.corso.dao.MatchDAO;
import com.corso.model.Match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MatchService {
	
	private MatchDAO dao;
	
	public void create(Match match) {
		dao.create(match); 
		System.out.println("Creata occorrenza con id " + match.getId());
	} 
	
	public Match find(int id) {
		return dao.find(Match.class, id);
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
	
	public void checkMatch(Match m) {
		m = findByInput(m.getInput());
		m.setConfirm(true);
		dao.update(m);
	}
	
	public void setDao(MatchDAO dao) {
		this.dao = dao;
	}
	
}
