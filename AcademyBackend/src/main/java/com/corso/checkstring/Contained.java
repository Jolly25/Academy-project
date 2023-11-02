package com.corso.checkstring;


import org.springframework.stereotype.Component;

@Component
public class Contained extends CheckStringWithList{

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Contained;
	}

	@Override
	protected boolean internalcheck(String s, String input) {
		return s.contains(input);
	}

}
