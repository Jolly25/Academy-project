package com.corso.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.corso.dao.UserDAO;
import com.corso.model.User;

public class UserService {

	@Autowired
	RisultatoService risultatoService;

	private UserDAO dao;

	public User create(User user) {
		return dao.create(user);
	}

	public void setDao(UserDAO userDAO) {
		this.dao = userDAO;
	}

	public User find(Integer id) {
		return dao.find(id);
	}

	public User findByUsername(String username){
		return dao.findByUsername(username);
	}

	public boolean userExists(String username) {
		if(findByUsername(username) != null) return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllAvailablePlayer() {
		List<User> allUsers = (List<User>) dao.all(User.class);
		List<User> players = new ArrayList<User>();
		for (User u: allUsers) {
			if(u.getRuolo().equals("User") && u.getStatus()) {
				players.add(u);
			}
		}
		return players;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllBannedPlayer() {
		List<User> allUsers = (List<User>) dao.all(User.class);
		List<User> players = new ArrayList<User>();
		for (User u: allUsers) {
			if(u.getRuolo().equals("User") && !u.getStatus()) {
				players.add(u);
			}
		}
		return players;
	}

	public void banPlayerById(int id) {
		User user = (User) dao.find(User.class, id);
		user.setStatus(false);
		dao.update(user);
	}
	
	
	public List<User> usersOrderedByScore(){
		List<User> users = getAllAvailablePlayer();
		Collections.sort(users);
		return users;
	}
	

	public List<User> getRanking() {
		List<User> players = getAllAvailablePlayer();

		for(User player: players) {
			int score = risultatoService.getPlayerScore(player.getId()); 
			player.setScore(score);
			dao.update(player);
		}
		
		List<User> ranking = usersOrderedByScore();
		return ranking;
	}
	




}
