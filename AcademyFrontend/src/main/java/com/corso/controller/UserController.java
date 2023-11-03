package com.corso.controller;

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
	
	@GetMapping("/game")
	public String getGamePage() {
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
