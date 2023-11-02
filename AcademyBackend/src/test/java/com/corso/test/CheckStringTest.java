package com.corso.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.beans.Beans;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.dao.MatchDAO;
import com.corso.model.Match;
import com.corso.model.User;
import com.corso.service.MatchService;
import com.corso.service.UserService;


public class CheckStringTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class);

		MatchService service = (MatchService) factory.getBean("matchService"); 
		
		Match m = service.findByInput("Ger");
		System.out.println(m.getAlgorithm());
		
	}

}
