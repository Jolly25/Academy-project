package com.corso.validation;

import javax.validation.constraints.NotEmpty;

public class LoginForm {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	private boolean status;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
