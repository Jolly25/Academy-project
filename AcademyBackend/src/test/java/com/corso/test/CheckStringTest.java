package com.corso.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.beans.Beans;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.AlgorithmType;
import com.corso.checkstring.CheckString;
import com.corso.dao.BaseDAO;
import com.corso.dao.MatchDAO;
import com.corso.model.AlgoResult;
import com.corso.model.Match;
import com.corso.model.Risultato;
import com.corso.model.Segnalazione;
import com.corso.model.User;
import com.corso.service.AlgorithmService;
import com.corso.service.BandiereRisultatoService;
import com.corso.service.MatchService;
import com.corso.service.RisultatoService;
import com.corso.service.SegnalazioneService;
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

		
		UserService service = (UserService) factory.getBean("userService"); 
		User u = new User();
		u.setUsername("user2");
		u.setNewPassword("Admin");
		u.setRuolo("User");
		u.setStatus(true);
		service.create(u);
		System.out.println(service.findByUsername("user").checkPassword("Admin"));
		
		MatchService service = (MatchService) factory.getBean("matchService"); 
		
		
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah");
		CheckString cs = ah.buildCheckString();
		MatchService matchService = (MatchService) factory.getBean("matchService"); 
		
		AlgorithmService service = (AlgorithmService) factory.getBean("algorithmService"); 
		//List<AlgoResult> algos = service.getAllAlgoResult();
		//Match m = new Match();
		//m.setInput("German");
		//matchService.checkMatch(m);
		//ah.trainAlgos();
		//Match m = service.findByInput("Ger");
		//System.out.println(cs.check("bvufsibvufidbzvz"));
		//System.out.println(algos.size());
		//CheckString c1 = ah.buildCheckString();
		//System.out.println(c1.next.next.getClass());
		//matchService.setMatchByAdmin("Italii", "Italy");
	*/
		
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah");
		ah.trainAlgos();
		
		UserService service = (UserService) factory.getBean("userService"); 
		User u = service.find(7);
		
		MatchService matchService = (MatchService) factory.getBean("matchService"); 
		Match m = matchService.findByInput("Ger");
		
		SegnalazioneService ss = (SegnalazioneService) factory.getBean("segnalazioneService"); 
		Segnalazione s = new Segnalazione();
		s.setIdUser(u);
		s.setMatch(m);
		ss.remove(ss.find(3));
		System.out.println(s.getIdUser().getId());

		
	}

}
