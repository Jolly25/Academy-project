package com.corso.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.model.Partita;
import com.corso.model.User;
import com.corso.service.PartitaService;
import com.corso.validation.MatchForm;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	CheckString matchCS;

	@Autowired
	AlgorithmHandler ah;
	
	@Autowired
	PartitaService partitaService;
	
	@GetMapping("/home_userr")
	public String getHomeUser() {
		return "homeUser";
	}
	
	@GetMapping("/game")
	public String getGamePage(Model m, HttpSession s) {
		/*
		int idUser =((User) s.getAttribute("user")).getId();
		
		List<String> array = new ArrayList<String>();
		array.add("Italy");
		array.add("Sweden");
		array.add("Germany");
		
		Risultato r = risultatoService.create(1, idUser, array);
		Gson gson = new Gson();
		String json = gson.toJson(r);
		m.addAttribute("partita", json);
		*/
		
		return "game";
	}
	
	@GetMapping("/form_checkstring")
	public String formCheckstring(Model m) {
		MatchForm matchForm = new MatchForm();
		m.addAttribute("matchForm", matchForm);
		return "formCheckstring";
	}

	@PostMapping("/checkstring")
	public String add(@ModelAttribute("matchForm") @Valid MatchForm matchForm, BindingResult bindingResult, @RequestParam("input") String input, Model m) {
		if(bindingResult.hasErrors()) {
			return "formCheckstring";
		}
		else {
			ah.buildCheckString();
			String match = matchCS.check(input);
			return "viewOutput";
		}
	}
	
	@PostMapping("/score")
	public String postScore(@RequestParam("partitaFinitaInput") String input, Model m) {
		Gson gson = new Gson();
		Risultato r = gson.fromJson(input, Partita.class);
		m.addAttribute("r", r);
		m.addAttribute("n", r.getCountriesToGuess().size());
		return "viewScore";
	}
	
	

}
