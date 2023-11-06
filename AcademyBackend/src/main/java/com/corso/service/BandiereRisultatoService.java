package com.corso.service;


import com.corso.dao.BandiereRisultatoDAO;
import com.corso.model.BandiereRisultato;

public class BandiereRisultatoService {

	private BandiereRisultatoDAO dao;
	
	public void create(BandiereRisultato br) {
		dao.create(br); 
	} 
	
	public void setDao(BandiereRisultatoDAO dao) {
		this.dao = dao;
	}
}
