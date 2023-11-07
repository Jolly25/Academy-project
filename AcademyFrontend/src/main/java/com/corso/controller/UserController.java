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
	
	@GetMapping("/game")
	public String getGamePage(Model m, HttpSession s) {
		User u = ((User) s.getAttribute("user"));
		List<BandiereRisultato> list = new ArrayList<BandiereRisultato>();
		
		if(s.getAttribute("partita")==null) {
			Risultato ris = new Risultato();
			ris.setIdUser(u);
			ris.setBandiereDaIndovinare(list);
			ris.setTurn(0);
			risultatoService.create(ris);
			risultatoService.insertBandiere(ris, 10);
			s.setAttribute("partita", ris);
		}
		
		Risultato risultato = (Risultato) s.getAttribute("partita"); 
		String flag = risultato.getBandiereDaIndovinare().get(risultato.getTurn()).getBandiera();		
		Gson gson = new Gson();
		String json = gson.toJson(flag);
		System.out.println(json);
		m.addAttribute("flag", json);
		
		return "game";
	}
	
	@PostMapping("/checkstring_prova")
	public String checkString(@RequestParam("input") String input, Model m, HttpSession s) {
		ah.buildCheckString();
		Gson gson = new Gson();
		Risultato ris = (Risultato) s.getAttribute("partita");
		String match = matchCS.check(input);
		String flag = ris.getBandiereDaIndovinare().get(ris.getTurn()).getBandiera();		
		String json = gson.toJson(flag);
		m.addAttribute("flag", json);
		json = gson.toJson(match);
		m.addAttribute("match", json);
		s.setAttribute("match", match);
		return "game";
	}
	
	@PostMapping("/turno")
	public String turnChange(Model m, HttpSession s) {
		Risultato r = (Risultato) s.getAttribute("partita");
		BandiereRisultato flag = r.getBandiereDaIndovinare().get(r.getTurn());
		String flagname = flag.getBandiera();
		String match = (String) s.getAttribute("match");
		System.out.println("ciao" + match);
		if(match.equals(flagname)) {
			flag.setIndovinato(true);
			r.setScore(r.getScore() + 1);
		}
		r.setBandiereViste(r.getBandiereViste() + 1);
		r.setTurn(r.getTurn() + 1);
		System.out.println(r.getTurn());
		if(r.getTurn() < r.getBandiereDaIndovinare().size()) {
			Gson gson = new Gson();
			flag = r.getBandiereDaIndovinare().get(r.getTurn());
			flagname = flag.getBandiera();
			String json = gson.toJson(flagname);
			m.addAttribute("flag", json);
			m.addAttribute("match", null);
			return "game";
		}
		return "redirect:/score";
	}
	
	@GetMapping("/score")
	public String postScore(Model m, HttpSession s) {
		Risultato r = (Risultato) s.getAttribute("partita");
		risultatoService.update(r);
		m.addAttribute("r", r);
		s.setAttribute("partita", null);
		return "viewScore";
	}
	

}
