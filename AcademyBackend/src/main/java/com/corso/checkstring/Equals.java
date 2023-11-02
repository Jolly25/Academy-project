package com.corso.checkstring;


import org.springframework.stereotype.*;

@Component
public class Equals extends CheckStringWithList{
	
	@Override
	protected boolean internalcheck(String s, String input) {
		return input.equals(s);
	}

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Equals;
	}

}
