package com.corso.checkstring;


import org.springframework.stereotype.*;

import com.corso.model.Algorithm;

@Component
public class Contains extends CheckStringWithList{
	
	@Override
	protected boolean internalcheck(String s, String input) {
		return input.contains(s);
	}

	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Contains);
	}

}
