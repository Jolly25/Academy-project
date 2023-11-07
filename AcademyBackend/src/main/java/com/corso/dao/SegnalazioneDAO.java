package com.corso.dao;

import java.util.List;

import com.corso.model.Segnalazione;

public class SegnalazioneDAO  extends BaseDAO{
	
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
