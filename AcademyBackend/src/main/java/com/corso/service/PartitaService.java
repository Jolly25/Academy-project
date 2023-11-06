package com.corso.service;

import java.util.List;

import com.corso.dao.PartitaDAO;
import com.corso.model.Partita;

public class PartitaService {

	private PartitaDAO dao;
	
	public Partita create(int id, int idUser, List<String> ctg) {
		return dao.create(id, idUser, ctg); 
	} 
	
	public void setDao(PartitaDAO dao) {
		this.dao = dao;
	}
}
