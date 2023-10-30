package com.corso.controller;

import java.util.List;

import javax.jws.WebParam;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.model.Match;
import com.corso.model.User;
import com.corso.beans.Beans;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;
import com.corso.service.MatchService;
import com.corso.service.UserService;
import com.corso.validation.LoginForm;
import com.corso.validation.MatchForm;


@Controller
@RequestMapping("/")
public class CheckStringController {

	@Autowired
	CheckString c1;

	@Autowired
	AlgorithmHandler ah;

	@Autowired
	MatchService matchService;

	@Autowired
	UserService userService;

	@RequestMapping(path = { "/", "/home" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home() {
		return "home";
	}

	@GetMapping("/form_add")
	public String formAdd(Model m) {
		MatchForm matchForm = new MatchForm();
		m.addAttribute("matchForm", matchForm);
		return "formAdd";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("matchForm") @Valid MatchForm matchForm, BindingResult bindingResult, @RequestParam("input") String input, Model m) {
		if(bindingResult.hasErrors()) {
			return "formAdd";
		}
		else {
			ah.buildCheckString();
			c1.check(input);
			return "viewOutput";
		}
	}

	@GetMapping("/view_matchlist")
	public String viewMatcheList(Model m) {
		List<Match> lista = matchService.getAllMatches();
		m.addAttribute("lista", lista);
		return "viewMatchList";
	}

	@GetMapping("/form_login")
	public String formLogin(Model m) {
		LoginForm loginForm = new LoginForm();
		m.addAttribute("loginForm", loginForm);
		return "formLogin";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formLogin";
		}
		else {
			String username = loginForm.getUsername();
			String pw = loginForm.getPassword();
			String pwr = loginForm.getRepeatPassword();
			if(!pw.equals(pwr)) {
				return "formLogin";
			}
			else {
				User u = userService.findByUsername(username);
				if(u != null) {
					if(u.checkPassword(pw)) {
						if(u.getRuolo().equals("Admin")) {
							return "loggedAdmin";
						}
						return "logged";
					}
				}
				return "formLogin";
			}

		}
	}

}
