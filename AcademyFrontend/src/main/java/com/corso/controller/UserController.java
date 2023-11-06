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
import com.corso.model.BandiereRisultato;
import com.corso.model.Risultato;
import com.corso.model.User;
import com.corso.service.RisultatoService;
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
	RisultatoService risultatoService;
	
	@GetMapping("/home_userr")
	public String getHomeUser() {
		return "homeUser";
	}
	
	@GetMapping("/game")
	public String getGamePage(Model m, HttpSession s) {
		User u = ((User) s.getAttribute("user"));
		List<BandiereRisultato> list = new ArrayList<BandiereRisultato>();
		
		Risultato ris = new Risultato();
		ris.setIdUser(u);
		ris.setBandiereDaIndovinare(list);
		risultatoService.create(ris);
		risultatoService.insertBandiere(ris, 10);
		//ris = risultatoService.find(ris.getId());
		
		Gson gson = new Gson();
		String json = gson.toJson(ris);
		m.addAttribute("partita", json);
		
		
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
		Risultato r = gson.fromJson(input, Risultato.class);
		risultatoService.update(r);
		m.addAttribute("r", r);
		return "viewScore";
	}
	
	

}
