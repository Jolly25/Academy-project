package com.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.model.Match;
import com.corso.service.MatchService;


@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	MatchService matchService;

	@GetMapping("/home_admin")
	public String getHomeAdmin() {
		return "homeAdmin";
	}
	
	@GetMapping("/view_matchlist")
	public String viewMatcheList(Model m) {
		List<Match> lista = matchService.getAllMatches();
		m.addAttribute("lista", lista);
		return "viewMatchList";
	}
	
}
