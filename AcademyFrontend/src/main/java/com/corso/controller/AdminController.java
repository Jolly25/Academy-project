package com.corso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.model.Match;
import com.corso.service.MatchService;
import com.google.gson.Gson;


@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	MatchService matchService;

	@GetMapping("/home_admin")
	public String getHomeAdmin() {
		return "homeAdmin";
	}
	
	@GetMapping("/matchlist")
	public void getMatchList(HttpServletResponse response) {
		System.out.println("We are in get");
	    List<Match> matchList = matchService.getAllUncheckedMatches();
	    String json = new Gson().toJson(matchList);
	    try {
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/matchlist")
	public void postMatchList(HttpServletRequest request) {
		String matchid = request.getParameter("matchid");
		System.out.println("We are in post, match: " + matchid);
	}
	
	@PostMapping("/checkmatch")
	public void postCheckmatch(HttpServletRequest request) {
		String matchid = request.getParameter("matchid");
		Match m = matchService.find(Integer.parseInt(matchid));
		matchService.checkMatch(m);
		System.out.println("Match " + matchid + " checked!");
	}
	
	@PostMapping("/removematch")
	public void postRemoveMatch(HttpServletRequest request) {
		String matchid = request.getParameter("matchid");
		Match m = matchService.find(Integer.parseInt(matchid));
		matchService.removeMatch(m);
		System.out.println("Match " + matchid + " removed!");
	}
	
	
	
	@GetMapping("/view_matchlist")
	public String viewMatcheList(Model m) {
		List<Match> lista = matchService.getAllMatches();
		m.addAttribute("lista", lista);
		return "viewMatchList";
	}
	
}
