package com.corso.dao;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.corso.model.BandiereRisultato;
import com.corso.model.Risultato;

public class RisultatoDAO extends BaseDAO{
	
	@Transactional
	public Risultato create(Risultato ris){
		return (Risultato) super.create(ris);
	}
	
	public void update(Risultato ris) {
		List<BandiereRisultato> bandiere = ris.getBandiereDaIndovinare();
		ris.setBandiereDaIndovinare(null);
		super.update(ris);
		for(BandiereRisultato br : bandiere) {
			super.update(br);
		}
	}
	
	@Transactional
	public void remove(Risultato ris) {
		super.remove(ris);
	}
	
	public int getPlayerScore(int id) {
		@SuppressWarnings("unchecked")
		List<Risultato> playerResults = (List<Risultato>) super.findAllByAttributeInt(Risultato.class, "IdUser", id);
		int bandiereIndovinate = 0; 
		int bandiereViste = 0; 
		for(Risultato r: playerResults) {
			bandiereIndovinate += r.getScore();
			bandiereViste += r.getBandiereViste();
		}
		int score = (int) Math.floor((double)bandiereIndovinate / (double)bandiereViste * 100);
		return score;
	}

	
}
