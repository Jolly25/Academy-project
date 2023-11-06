package com.corso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

import com.corso.model.BandiereRisultato;
import com.corso.model.Risultato;

public class BandiereRisultatoDAO extends BaseDAO{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	@Transactional
	public void create(BandiereRisultato br){
		em.getTransaction().begin();
		em.persist(br);
		em.getTransaction().commit();
	}
	
}
