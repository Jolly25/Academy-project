package com.corso.service;


import com.corso.dao.BandiereRisultatoDAO;
import com.corso.model.BandiereRisultato;

public class BandiereRisultatoService {

	private BandiereRisultatoDAO dao;
	
	public BandiereRisultato create(BandiereRisultato br) {
		return dao.create(br); 
	} 
	
	public void setDao(BandiereRisultatoDAO dao) {
		this.dao = dao;
	}
	
	public void deleteBandierePartita(int partitaId) {
		dao.deleteBandierePartita(partitaId);
	}
}
