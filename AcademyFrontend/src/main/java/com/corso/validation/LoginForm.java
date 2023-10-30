package com.corso.validation;

import javax.validation.constraints.NotEmpty;

public class LoginForm {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String repeatPassword;
	
	public String getUsername() {
		return username;
	}
	
	public String getRepeatPassword() {
		return repeatPassword;
	}
	
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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
}
