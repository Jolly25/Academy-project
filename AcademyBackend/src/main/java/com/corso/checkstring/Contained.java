package com.corso.checkstring;


import org.springframework.stereotype.Component;

import com.corso.model.Algorithm;

@Component
public class Contained extends CheckStringWithList{

	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Contained);
	}

	@Override
	protected boolean internalcheck(String s, String input) {
		return s.contains(input);
	}

}
