package com.corso.controller;

import java.util.List;

import javax.jws.WebParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.corso.model.Match;
import com.corso.model.Segnalazione;
import com.corso.model.User;
import com.corso.service.MatchService;
import com.corso.service.SegnalazioneService;
import com.corso.service.UserService;


@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	MatchService matchService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SegnalazioneService segnalazioneService;

	@GetMapping("/home_admin")
	public String getHomeAdmin() {
		return "homeAdmin";
	}
	
	@GetMapping(path={"/matchlist"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
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
	@ResponseBody
	public List<Segnalazione> getReportList() {
	    List<Segnalazione> reportList = segnalazioneService.getAllSegnalazioni();
	    return reportList;
	}
	
	@PostMapping("/approvasegnalazione")
	public void postApprovaSegnalazione(@WebParam int reportid) {
		Segnalazione s = segnalazioneService.find(reportid);
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

    @GetMapping("/users")
    public List<User> getPlayerList() {
        List<User> players = userService.getAllAvailablePlayer();
        return players;
    }
    
	@GetMapping(path={"/ranking"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<User> getRanking() {
	    List<User> ranking = userService.getRanking();
	    return ranking;
	}

}
