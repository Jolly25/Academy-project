package com.corso.dao;

import com.corso.model.BandiereRisultato;

public interface BandiereRisultatoDAO extends BaseDAO{
	
	public BandiereRisultato create(BandiereRisultato br);
	
	public void deleteBandierePartita(int partitaId);
}
