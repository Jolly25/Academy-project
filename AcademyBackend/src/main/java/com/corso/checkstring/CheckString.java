package com.corso.checkstring;

import com.corso.service.AlgorithmService;
import com.corso.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.model.Algorithm;
import com.corso.model.Match;

public abstract class CheckString {
	
	String output;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private AlgorithmService algorithmService;

	public CheckString next;
	
	public CheckString(CheckString next) {
		this.next = next;
	}
	
	public CheckString() {}
	
	public final String check(String input) {
		String matchedword = checkimpl(input);
		
		if(matchedword != null && !matchedword.equals("")) {
			if(!getAlgo().getAlgorithm().equals(AlgorithmType.Match)){
				Match m = new Match();
				m.setInput(input);
				m.setStandardword(matchedword);
				m.setAlgorithm(algorithmService.getAlgorithmByType(getAlgo().getAlgorithm()));
				m.setConfirm(false);
				if(input.toLowerCase().equals(matchedword.toLowerCase())) m.setConfirm(true);
				matchService.create(m);
			}
			System.out.println("Trovata parola con " + this.getClass().getSimpleName() + ": " + matchedword);
			return matchedword;
		}
		
		if(matchedword != null && matchedword.equals("")) {
			System.out.println("Parola non trovata con gli algoritmi a disposizione");
			return null;
		}
		
		if(next != null) return next.check(input);
		Match m = new Match();
		m.setInput(input);
		m.setAlgorithm(algorithmService.getAlgorithmByType(AlgorithmType.NotFound));
		m.setConfirm(false);
		matchService.create(m);
		System.out.println("Parola non trovata con gli algoritmi a disposizione");
		return null;
	}
	
	protected abstract Algorithm getAlgo();

	protected abstract String checkimpl(String input);

	public final void setNext(CheckString next) {
		this.next  = next;
	}
	
	public void checkMatch(String input, String match) {
		Match m = new Match();
		m.setInput(input);
		m.setStandardword(match);
		//matchService.checkMatch(m);
	}
	
}
