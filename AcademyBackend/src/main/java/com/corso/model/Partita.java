package com.corso.model;

import java.util.List;

public class Partita {
	
	private int id;
	
	private int idUser;
	
	private List<String> countriesToGuess;
	
	private int score;


	public Partita(int id, int idUser, List<String> countriesToGuess) {
		this.id = id;
		this.idUser = idUser;
		this.countriesToGuess = countriesToGuess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<String> getCountriesToGuess() {
		return countriesToGuess;
	}

	public void setCountriesToGuess(List<String> countriesToGuess) {
		this.countriesToGuess = countriesToGuess;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
