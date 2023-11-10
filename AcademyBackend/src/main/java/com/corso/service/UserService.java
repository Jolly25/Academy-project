package com.corso.service;

import java.util.ArrayList;
import java.util.List;

import com.corso.dao.UserDAO;
import com.corso.model.User;

public class UserService {

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
	
}
