package com.corso.validation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class RegisterForm {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z]).{5,}$", message="minimo 5 caratteri, almeno una lettera e un numero")
	private String password;
	
	@NotEmpty
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z]).{5,}$", message="minimo 5 caratteri, almeno una lettera e un numero")
	private String confirmPassword;
	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
