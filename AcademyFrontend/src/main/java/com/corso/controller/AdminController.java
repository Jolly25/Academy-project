package com.corso.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.checkstring.AlgorithmHandler;
import com.corso.logging.LoggingAnnotations.*;
import com.corso.service.AlgorithmService;
import com.corso.service.MatchService;
import com.corso.service.SegnalazioneService;
import com.corso.service.StandardWordService;
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
	
	@Autowired
	AlgorithmService algorithmService;
	
	@Autowired
	StandardWordService swService;

	@Autowired
	AlgorithmHandler ah;
	
	@LogMethod
	@GetMapping("/home_admin")
	public String getHomeAdmin(Model m, HttpSession s) {
		m.addAttribute("user", s.getAttribute("user"));
		return "homeAdmin";
	}
	
	@GetMapping("/not_admin")
	public String notAdminPage(Model m) {
		m.addAttribute("message", "Non sei autorizzato ad accedere a questa risorsa");
		return "errorPage";
	}

}
