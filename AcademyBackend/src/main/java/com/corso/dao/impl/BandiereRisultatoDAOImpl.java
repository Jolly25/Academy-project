package com.corso.dao.impl;

import java.util.List;

import com.corso.dao.BandiereRisultatoDAO;
import com.corso.model.BandiereRisultato;

public class BandiereRisultatoDAOImpl extends BaseDAOImpl implements BandiereRisultatoDAO{
	
	public BandiereRisultato create(BandiereRisultato br){
		return (BandiereRisultato) super.create(br);
	}
	
	public void deleteBandierePartita(int partitaId) {
		@SuppressWarnings("unchecked")
		List<BandiereRisultato> list = (List<BandiereRisultato>) super.findAllByAttributeInt(BandiereRisultato.class, "IdRisultato", partitaId);
		for(BandiereRisultato br: list) {
			super.remove(br);
		}
	}
	
}
