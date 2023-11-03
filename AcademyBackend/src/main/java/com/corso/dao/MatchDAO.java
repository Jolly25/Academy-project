package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.corso.model.Match;

public class MatchDAO extends BaseDAO{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("match_pu");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	@Transactional
	public void create(Match match){
		em.getTransaction().begin();
		em.persist(match);
		em.getTransaction().commit();
	}

	public Match find(Class classe, Integer id){
		System.out.println("Siamo qui");
		return (Match) em.find(classe, id);
	} 
	
	public Match findByInput(String input) {
		return (Match) super.findByAttribute(Match.class, "Input", input);
	}

	public int countMatches(String algorithm) {
		String jpql = "from Match where algorithm = :algorithm";  
	    Query q =  em.createQuery(jpql, Match.class);
	    q.setParameter("algorithm", algorithm);
	    
	    List<Match> list = q.getResultList();
		
	    return list.size();
	}
	
	public List<Match> getAllMatches() {
		String jpql = "from Match";
		Query q = em.createQuery(jpql, Match.class);
		
	    List<Match> list = q.getResultList();
		
	    return list;
	}

}
