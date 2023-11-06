package com.corso.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.corso.dao.RisultatoDAO;
import com.corso.model.BandiereRisultato;
import com.corso.model.Risultato;

public class RisultatoService {

	private RisultatoDAO dao;
	
	@Autowired
	BandiereRisultatoService brs;
	
	public Risultato create(Risultato ris) {
		return dao.create(ris); 
	} 
	
	public void update(Risultato ris) {
		dao.update(ris);
	}
	
	public Risultato find(int id) {
		return (Risultato) dao.find(Risultato.class, id);
	}
	
	public void setDao(RisultatoDAO dao) {
		this.dao = dao;
	}
	
	public void insertBandiere(Risultato ris, int num) {
		List<String> list = new ArrayList<String>();
		list.add("Italy");
		list.add("Sweden");
		list.add("Germany");
		
		for(String s: list) {
			BandiereRisultato br = new BandiereRisultato();
			br.setIdRisultato(ris.getId());
			br.setBandiera(s);
			br.setIndovinato(false);
			ris.getBandiereDaIndovinare().add(brs.create(br));
		}
	}
	
}
