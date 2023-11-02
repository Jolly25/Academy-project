package com.corso.checkstring;


import org.springframework.stereotype.*;

@Component
public class Contains extends CheckStringWithList{
	
	@Override
	protected boolean internalcheck(String s, String input) {
		return input.contains(s);
	}

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Contains;
	}

}
