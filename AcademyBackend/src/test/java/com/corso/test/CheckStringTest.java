package com.corso.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.beans.Beans;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.dao.MatchDAO;
import com.corso.model.AlgoResult;
import com.corso.model.Match;
import com.corso.model.User;
import com.corso.service.AlgorithmService;
import com.corso.service.MatchService;
import com.corso.service.UserService;


public class CheckStringTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class);

		/*
		CheckString c1 = (CheckString) factory.getBean("c1");
		CheckString c2 = (CheckString) factory.getBean("c1");
		
		c1.setNext(c2);
		
		CheckString c3 = (CheckString) factory.getBean("c1");
		System.out.println(c3.next);
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah");
		
		//ah.buildCheckString();
	
		//cs.check("Ireiondd");
		
		UserService service = (UserService) factory.getBean("userService"); 
		User u = service.findByUsername("User9");
		System.out.println(u);

		/*
		UserService service = (UserService) factory.getBean("userService"); 
		User u = new User();
		u.setUsername("user2");
		u.setNewPassword("Admin");
		u.setRuolo("User");
		u.setStatus(true);
		service.create(u);
		System.out.println(service.findByUsername("user").checkPassword("Admin"));
		MatchService service = (MatchService) factory.getBean("matchService"); 
		
		MatchService service = (MatchService) factory.getBean("matchService"); 
		*/
		
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah");
		CheckString cs = ah.buildCheckString();
		
		AlgorithmService service = (AlgorithmService) factory.getBean("algorithmService"); 
		List<AlgoResult> algos = service.getAllAlgoResult();
		
		//Match m = service.findByInput("Ger");
		System.out.println(cs.check("Itala"));
		//System.out.println(algos.size());
		
	}

}
