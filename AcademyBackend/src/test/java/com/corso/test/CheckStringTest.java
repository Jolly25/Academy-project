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

		/*
		CheckString cs = (CheckString) factory.getBean("c1"); 
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah"); 
		
		ah.buildCheckString();
		
		
		cs.check("Germanyy");
		
		MatchDAO dao = (MatchDAO) factory.getBean("matchDao");
		Match m = dao.findByInput("Germany");
		System.out.println(m.getStandardword());
		*/

		UserService service = (UserService) factory.getBean("userService"); 
		User u = new User();
		u.setUsername("user2");
		u.setNewPassword("Admin");
		u.setRuolo("User");
		u.setStatus(true);
		service.create(u);
		//System.out.println(service.findByUsername("user").checkPassword("Admin"));
		
		
		
		//MatchService mser = (MatchService) factory.getBean("matchService");
		//System.out.println(mser.find(9).getInput());
	}

}
