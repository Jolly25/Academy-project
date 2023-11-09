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
		System.out.println("Siamo nella home dello user");
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
			//String match = matchCS.check(input);
			return "viewOutput";
		}
	}
	
	@GetMapping("/start_game")
	public String startGame(Model m, HttpSession s) {
		
		s.setAttribute("partita", null);
		User u = ((User) s.getAttribute("user"));
		Risultato ris = new Risultato();
		ris.setIdUser(u);
		List<BandiereRisultato> list = new ArrayList<BandiereRisultato>();
		ris.setBandiereDaIndovinare(list);
		ris.setTurn(0);
		risultatoService.create(ris);
		risultatoService.insertBandiere(ris, 5);
		s.setAttribute("partita", ris);
		
		return "redirect:/game";
		
	}
	
	@GetMapping("/game")
	public String getGamePage(Model m, HttpSession s) {

		Risultato risultato = (Risultato) s.getAttribute("partita"); 
		String flag = risultato.getBandiereDaIndovinare().get(risultato.getTurn()).getBandiera();		
		m.addAttribute("flag", flag);
		m.addAttribute("score", risultato.getScore());
		
		return "game";
	}
	
	@PostMapping("/turno")
	public String turnChange(@RequestParam("input") String input, Model m, HttpSession s) {
		ah.buildCheckString();
		String match = matchCS.check(input);
		if(match == null) match = "";
		Risultato r = (Risultato) s.getAttribute("partita");
		BandiereRisultato pFlag = r.getBandiereDaIndovinare().get(r.getTurn());
		String pFlagname = pFlag.getBandiera();
		if(match.toLowerCase().trim().equals(pFlagname.toLowerCase().trim())) {
			pFlag.setIndovinato(true);
			r.setScore(r.getScore() + 1);
		}
		r.setBandiereViste(r.getBandiereViste() + 1);
		r.setTurn(r.getTurn() + 1);
		if(r.getTurn() < r.getBandiereDaIndovinare().size()) {
			Gson gson = new Gson();
			BandiereRisultato flag = r.getBandiereDaIndovinare().get(r.getTurn());
			String flagname = flag.getBandiera();
			//String json = gson.toJson(flagname);
			m.addAttribute("flag", flagname);
			m.addAttribute("previousFlag", pFlagname);
			m.addAttribute("previousInput", input);
			m.addAttribute("previousMatch", match);
			m.addAttribute("score", r.getScore());
			return "game";
		}
		m.addAttribute("flag", pFlagname);
		m.addAttribute("previousFlag", pFlagname);
		m.addAttribute("previousInput", input);
		m.addAttribute("previousMatch", match);
		risultatoService.update(r);
		m.addAttribute("r", r);
		s.setAttribute("partita", null);
		return "viewScore";
	}

	

}
