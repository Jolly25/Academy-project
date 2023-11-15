package com.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.corso.logging.LoggingAnnotations.LoginLog;
import com.corso.model.User;
import com.corso.service.UserService;

@Controller
@RequestMapping("/")
public class RankingController {
	
	@Autowired
	UserService userService;
	
	@LoginLog
	@GetMapping("/ranking_list")
	public String getRankingList() {
		return "rankingList";
	}
	
    @GetMapping(path={"/usersRanking"}, produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<User> getRankingUserList() {
	    List<User> ranking = userService.getRanking();
	    return ranking;
	}
}