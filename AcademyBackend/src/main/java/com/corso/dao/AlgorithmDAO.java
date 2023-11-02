package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.corso.model.AlgoResult;

public class AlgorithmDAO extends BaseDAO{

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	
	public List<AlgoResult> getAllAlgoResult() {
		String jpql = "from Match";
		Query q = em.createQuery(jpql, AlgoResult.class);
		
	    List<AlgoResult> list = q.getResultList();
		
	    return list;
	}

}
