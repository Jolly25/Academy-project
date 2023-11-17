package com.corso.dao;

import com.corso.model.Risultato;

public interface RisultatoDAO extends BaseDAO{
	
	public Risultato create(Risultato ris);
	
	public void update(Risultato ris);
	
	public void remove(Risultato ris);
	
	public int getPlayerScore(int id);

}
