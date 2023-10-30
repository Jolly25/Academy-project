package com.corso.validation;

import javax.validation.constraints.Size;



public class MatchForm {
	
	@Size(min=2, max=20)
	private String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	
}
