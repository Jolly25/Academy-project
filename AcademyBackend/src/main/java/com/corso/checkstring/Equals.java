package com.corso.checkstring;


import org.springframework.stereotype.*;

import com.corso.model.Algorithm;

@Component
public class Equals extends CheckStringWithList{
	
	@Override
	protected boolean internalcheck(String s, String input) {
		return input.equals(s);
	}

	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Equals);
	}

}
