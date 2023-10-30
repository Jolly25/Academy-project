package com.corso.model;

import java.nio.charset.StandardCharsets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.hash.Hashing;

@Entity
@Table(name = "Users")
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdUser")
	private int id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Ruolo")
	private String ruolo;
	
	@Column(name="Status")
	private boolean status;

	
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNewPassword(String pass) {
		String cryptpass = Hashing.sha256().hashString(pass, StandardCharsets.UTF_8).toString();
		this.password = cryptpass;
	}
	
	public boolean checkPassword(String userpassword) {
		String cryptpass = Hashing.sha256().hashString(userpassword, StandardCharsets.UTF_8).toString();
		return this.password.equals(cryptpass);
	}
	
	
	public String getPassword() {
		return password;
	}
}
