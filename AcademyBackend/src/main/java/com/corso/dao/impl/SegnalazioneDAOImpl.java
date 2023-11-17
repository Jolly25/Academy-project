package com.corso.dao.impl;

import java.util.List;

import com.corso.dao.SegnalazioneDAO;
import com.corso.model.Segnalazione;

public class SegnalazioneDAOImpl  extends BaseDAOImpl implements SegnalazioneDAO{
	
	public void create(Segnalazione s){
		super.create(s);
	}
	
	public void remove(Segnalazione s) {
		super.remove(s);
	}

	public Segnalazione find(Integer id){
		return (Segnalazione) super.find(Segnalazione.class, id);
	} 
	
	@SuppressWarnings("unchecked")
	public List<Segnalazione> getAllSegnalazioni() {
		return (List<Segnalazione>) super.all(Segnalazione.class);
	}
}
