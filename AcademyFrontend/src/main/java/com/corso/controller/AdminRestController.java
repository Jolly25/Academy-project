package com.corso.controller;

import java.util.Collections;
import java.util.List;

import javax.jws.WebParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corso.checkstring.AlgorithmHandler;
import com.corso.model.AlgoResult;
import com.corso.model.Match;
import com.corso.model.Segnalazione;
import com.corso.model.User;
import com.corso.service.AlgorithmService;
import com.corso.service.MatchService;
import com.corso.service.SegnalazioneService;
import com.corso.service.StandardWordService;
import com.corso.service.UserService;


@RestController
@RequestMapping("/")
public class AdminRestController {

	@Autowired
	MatchService matchService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SegnalazioneService segnalazioneService;
	
	@Autowired
	AlgorithmService algorithmService;
	
	@Autowired
	StandardWordService swService;

	@Autowired
	AlgorithmHandler ah;
	
	@GetMapping(path={"/matchlist"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Match> getMatchList() {
	    List<Match> matchList = matchService.getAllUncheckedMatches();
	    return matchList;
	}
	
	@PostMapping("/checkmatch")
	public void postCheckmatch(@WebParam int matchid) {
		Match m = matchService.find(matchid);
		matchService.checkMatch(m);
		System.out.println("Match " + matchid + " checked!");
	}
	
	@PostMapping("/removematch")
	public void postRemoveMatch(@WebParam int matchid) {
		Match m = matchService.find(matchid);
		matchService.removeMatch(m);
		System.out.println("Match " + matchid + " removed!");
	}
	
	@GetMapping(path={"/reportlist"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Segnalazione> getReportList() {
	    List<Segnalazione> reportList = segnalazioneService.getAllSegnalazioni();
	    return reportList;
	}
	
	@PostMapping("/approvasegnalazione")
	public void postApprovaSegnalazione(@WebParam int reportid) {
		Segnalazione s = segnalazioneService.find(reportid);
		segnalazioneService.remove(s);
		matchService.removeMatch(s.getMatch());
		System.out.println("Segnalazione " + s.getId() + " approvata!");
	}
	
	@PostMapping("/removesegnalazione")
	public void postRemoveSegnalazione(@WebParam int reportid) {
		Segnalazione s = segnalazioneService.find(reportid);
		segnalazioneService.remove(s);
		System.out.println("Segnalazione " + s.getId() + " removed!");
	}
	
    @PostMapping("/banPlayer")
    public void banPlayer(@WebParam int playerId) {
        userService.banPlayerById(playerId);
    }

    @GetMapping(path={"/users"}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getPlayerList() {
        List<User> players = userService.getAllAvailablePlayer();
        return players;
    }
    
	@GetMapping(path={"/ranking"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getRanking() {
	    List<User> ranking = userService.getRanking();
	    return ranking;
	}
	
	@GetMapping(path={"/algorithm"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<AlgoResult> getAlgoresult() {
	
	    List<AlgoResult> algorithm = algorithmService.getAllAlgoResult();
	    Collections.sort(algorithm);
	    return algorithm;
	    
	}
	
	@GetMapping(path={"/allStandardWords"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<String> getAllStandardWords() {
	    List<String> standardwords = swService.getStandardWords();
	    return standardwords;
	    
	}
	
	@PostMapping("/setAdminMatch")
    public void setAdminMatch(@WebParam String input, @WebParam String standardword) {
		System.out.println(input + "  admin  " + standardword);
        matchService.setMatchByAdmin(input, standardword);
    }
	
	@PostMapping("/setAdminMatchReport")
    public void setAdminMatchReport(@WebParam String input, @WebParam String standardword, @WebParam int idreport) {
		System.out.println(input + "  report  " + standardword);
        matchService.setMatchByAdmin(input, standardword);
        Segnalazione s = segnalazioneService.find(idreport);
		segnalazioneService.remove(s);
    }
	
	@PostMapping("/trainAlgos")
    public void trainAlgos() {
        ah.trainAlgos();
    }

}
