package com.corso.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.corso.logging.LoggingAnnotations.*;
import com.corso.model.User;
import com.corso.service.UserService;
import com.corso.validation.LoginForm;
import com.corso.validation.RegisterForm;


@Controller
@RequestMapping("/")
public class CheckStringController {

	@Autowired
	UserService userService;

	@RequestMapping(path = { "/home_user" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home() {
		return "homeUser";
	}

	@GetMapping("/")
	public String formLogin(Model m) {
		LoginForm loginForm = new LoginForm();
		m.addAttribute("loginForm", loginForm);
		return "formLogin";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") @Valid LoginForm lf, BindingResult br, HttpSession session) {
		if(br.hasErrors()) {
			return "formLogin";
		}

		String username = lf.getUsername();
		String pw = lf.getPassword();
		User u = userService.findByUsername(username);
		if(u == null) {
			System.out.println("User not found");
			br.rejectValue("username", "error.username", "Username errato");
			return "formLogin";
		}
		
		if(!u.getStatus()) {
			br.rejectValue("status", "error.status", "Sei stato bannato");
			return "formLogin";
		}

		if(!u.checkPassword(pw)) {
			br.rejectValue("password", "error.password", "Password errata");
			return "formLogin";
		}

		if(u.getRuolo().equals("Admin")) {
			session.setAttribute("user", u);
			return "redirect:/home_admin";
		}
		else {
			session.setAttribute("user", u);
			return "redirect:/home_userr";
		}
	}

	@GetMapping("/form_register")
	public String formRegister(Model m) {
		RegisterForm registerForm = new RegisterForm();
		m.addAttribute("registerForm", registerForm);
		return "formRegister";
	}

	@LogMethod
	@PostMapping("/register")
	public String register(@ModelAttribute("registerForm") @Valid RegisterForm rf, BindingResult br) {
		if(br.hasErrors()) {
			return "formRegister";
		}

		if(!(rf.getPassword().equals(rf.getConfirmPassword()))) {
			br.rejectValue("confirmPassword", "error.confirmPassword", "Le password non corrispondono");
			return "formRegister";
		}

		if(userService.userExists(rf.getUsername())) {
			br.rejectValue("username", "error.username", "Sei già registrato");
			return "formRegister";
		}
		
		User u = new User();
		u.setUsername(rf.getUsername());
		u.setNewPassword(rf.getPassword());
		u.setRuolo("User");
		u.setStatus(true);
		u.setScore(0);
		if(userService.create(u) == null) {
			br.rejectValue("username", "error.username", "Sei già registrato");
			return "formRegister";
		}
		return "redirect:/";
	}

	@LogMethod
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	} 
	
	@GetMapping("/not_logged")
	public String notLoggedPage(Model m) {
		m.addAttribute("message", "Non hai ancora eseguito l'accesso oppure la sessione è scaduta");
		return "errorPage";
	}

}
