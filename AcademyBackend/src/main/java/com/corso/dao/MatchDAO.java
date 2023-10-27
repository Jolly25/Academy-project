package com.corso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
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
	    //Query q =  em.createQuery("from Match where input = :input", Match.class);
	    //q.setParameter("input", input);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Match> cq = cb.createQuery(Match.class);
		Root<Match> r = cq.from(Match.class);
		cq.select(r);
		cq.where(cb.equal(r.get("input"), input));
		
	    List<Match> list = em.createQuery(cq).getResultList();
		
		if(list.size() > 0) {
			return list.get(0);
		}
		else return null;
		
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
