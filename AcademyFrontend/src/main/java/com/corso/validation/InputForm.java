package com.corso.validation;

import javax.validation.constraints.Size;



public class InputForm {
	
	@Size(min=1, max=30)
	private String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	
}
