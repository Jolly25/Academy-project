package com.corso.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.beans.Beans;
import com.corso.checkstring.CheckStringWithList;
import com.corso.dao.MatchDAO;
import com.corso.model.Match;
import com.corso.service.MatchService;
import com.corso.service.StandardWordService;
import com.corso.standardwords.AlgorithmType;

public class CheckStringTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class);

		CheckStringWithList cs = (CheckStringWithList) factory.getBean("contains"); 
		//MatchDAO matchDAO = (MatchDAO) factory.getBean("matchDAO"); 

		cs.check("Ital");
		
	 	MatchDAO dao = factory.getBean("dao", MatchDAO.class); 
	 	
	 	Match m = new Match();
	 	
	 	m.setInput("Giamaica");
	 	m.setStandardword("Giamaicano");
	 	m.setAlgorithm(AlgorithmType.Admin);
	 	
	 	//dao.create(m);
	 	
	 	m = dao.find(Match.class, 3);
	 	
	 	//System.out.println(m.getInput());
		
		
		//StandardWordService sw = (StandardWordService) factory.getBean("swService"); 
		//System.out.println(sw.findAll());
	}

}
