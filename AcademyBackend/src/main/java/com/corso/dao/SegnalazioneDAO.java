package com.corso.dao;

import java.util.List;

import com.corso.model.Segnalazione;

public interface SegnalazioneDAO extends BaseDAO{
	
	public void create(Segnalazione s);
	
	public void remove(Segnalazione s);

	public Segnalazione find(Integer id);
	
	public List<Segnalazione> findAllByMatchInput(String matchinput);

	public List<Segnalazione> getAllSegnalazioni();
}
