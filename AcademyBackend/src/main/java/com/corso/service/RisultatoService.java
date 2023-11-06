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
	
	public void create(Risultato ris) {
		dao.create(ris); 
	} 
	
	public void setDao(RisultatoDAO dao) {
		this.dao = dao;
	}
	
	public void insertBandiere(Risultato ris) {
		List<String> list = new ArrayList<String>();
		list.add("Italy");
		list.add("Sweden");
		list.add("Germany");
		
		for(String s: list) {
			BandiereRisultato br = new BandiereRisultato(ris.getId(), s, false);
			brs.create(br);
		}
	}
	
}
