package com.corso.checkstring;

import com.corso.standardwords.AlgorithmType;

public class Levenshtein2 extends Levenshtein{

	public Levenshtein2() {
		super(2);
	}

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Levenshtein2;
	}

}
