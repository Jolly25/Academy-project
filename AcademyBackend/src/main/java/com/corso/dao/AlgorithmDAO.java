package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.corso.checkstring.AlgorithmType;
import com.corso.model.AlgoResult;
import com.corso.model.Algorithm;

public class AlgorithmDAO extends BaseDAO{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	
	public List<AlgoResult> getAllAlgoResult() {
		String jpql = "from AlgoResult";
		Query q = em.createQuery(jpql, AlgoResult.class);
		
	    List<AlgoResult> list = q.getResultList();
		
	    return list;
	}
	
	public Algorithm getAlgorithmByType(AlgorithmType type) {
		return (Algorithm) super.findByAttribute(Algorithm.class, "Nome", type.toString());
	}

}
