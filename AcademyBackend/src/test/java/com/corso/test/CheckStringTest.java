package com.corso.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.beans.Beans;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.dao.MatchDAO;
import com.corso.model.Match;
import com.corso.standardwords.AlgorithmType;

public class CheckStringTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class);

		CheckString cs = (CheckString) factory.getBean("c1"); 
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah"); 
		
		ah.buildCheckString();
		
		String s = "Germanyy";
		cs.check(s.toUpperCase()); //ho messo toUpperCase perchè nel mio db le parole standard sono in stampatello
		
		/*
		MatchDAO dao = factory.getBean("matchDao", MatchDAO.class);
	 	Match m = new Match();
	 	m.setInput("Francee");
	 	m.setStandardword("FRANCE");
	 	m.setAlgorithm(AlgorithmType.Admin);
	 	dao.create(m);
		*/
	}

}
