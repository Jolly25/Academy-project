package com.corso.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.corso.validation.MatchForm;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	CheckString matchCS;

	@Autowired
	AlgorithmHandler ah;
	
	@GetMapping("/home_userr")
	public String getHomeUser() {
		return "homeUser";
	}
	
	@GetMapping("/game")
	public String getGamePage(Model m) {
		//Partita p = partitaService.creaPartita();
		//List<String> l = p.getArrayOfCountries();
		List<String> array = new ArrayList<String>();
		array.add("Italy");
		array.add("France");
		array.add("Germany");
		m.addAttribute("array", array);
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

}
