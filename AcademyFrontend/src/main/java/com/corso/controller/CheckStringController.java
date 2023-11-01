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
import org.springframework.validation.ObjectError;
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
import com.corso.validation.RegisterForm;


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
	public String login(@ModelAttribute("loginForm") @Valid LoginForm lf, BindingResult br) {
		if(br.hasErrors()) {
			return "formLogin";
		}

		String username = lf.getUsername();
		String pw = lf.getPassword();
		User u = userService.findByUsername(username);
		if(u == null) {
			br.rejectValue("username", "error.username", "Incorrect username");
		}
		if(br.hasErrors()) {
			return "formLogin";
		}
		
		if(!u.checkPassword(pw)) {
			br.rejectValue("password", "error.password", "Incorrect password");
		}
		if(br.hasErrors()) {
			return "formLogin";
		}

		if(u.getRuolo().equals("Admin")) {
			return "loggedAdmin";
		}
		else return "logged";
	}

	@GetMapping("/form_register")
	public String formRegister(Model m) {
		RegisterForm registerForm = new RegisterForm();
		m.addAttribute("registerForm", registerForm);
		return "formRegister";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("registerForm") @Valid RegisterForm rf, BindingResult br) {
		if(!(rf.getPassword().equals(rf.getConfirmPassword()))) {
			br.rejectValue("confirmPassword", "error.confirmPassword", "Password do not match");
		}

		if(br.hasErrors()) {
			return "formRegister";
		}
		else {
			User u = new User();
			u.setUsername(rf.getUsername());
			u.setNewPassword(rf.getPassword());
			u.setRuolo("User");
			u.setStatus(true);
			userService.create(u);
			return "home";
		}
	}

}
