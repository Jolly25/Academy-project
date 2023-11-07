package com.corso.service;

import java.util.List;

import com.corso.dao.SegnalazioneDAO;
import com.corso.model.Segnalazione;

public class SegnalazioneService {
	
	private SegnalazioneDAO dao;
	
	public void create(Segnalazione s){
		dao.create(s);
	}
	
	public void remove(Segnalazione s) {
		dao.remove(s);
	}

	public Segnalazione find(Integer id){
		return dao.find(id);
	} 
	
	public List<Segnalazione> getAllSegnalazioni() {
		return dao.getAllSegnalazioni();
	}
	
	public void setDao(SegnalazioneDAO dao) {
		this.dao = dao;
	}
}
