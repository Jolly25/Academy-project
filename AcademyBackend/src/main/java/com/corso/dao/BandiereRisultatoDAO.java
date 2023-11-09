package com.corso.dao;

import java.util.List;

import com.corso.model.BandiereRisultato;

public class BandiereRisultatoDAO extends BaseDAO{
	
	public BandiereRisultato create(BandiereRisultato br){
		return (BandiereRisultato) super.create(br);
	}
	
	public void deleteBandierePartita(int partitaId) {
		@SuppressWarnings("unchecked")
		List<BandiereRisultato> list = (List<BandiereRisultato>) super.findAllByAttributeWithId(BandiereRisultato.class, "IdRisultato", partitaId);
		for(BandiereRisultato br: list) {
			super.remove(br);
		}
	}
	
}
