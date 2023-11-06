package com.corso.dao;


import org.springframework.transaction.annotation.Transactional;

import com.corso.model.Risultato;

public class RisultatoDAO extends BaseDAO{
	
	@Transactional
	public Risultato create(Risultato ris){
		return (Risultato) super.create(ris);
	}
	
	
	
}
