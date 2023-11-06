package com.corso.dao;

import java.util.List;

import com.corso.model.Partita;

public class PartitaDAO extends BaseDAO{

	public Partita create(int id, int idUser, List<String> ctg) {
		Partita p = new Partita(id, idUser, ctg);
		return p;
	}
	
}
