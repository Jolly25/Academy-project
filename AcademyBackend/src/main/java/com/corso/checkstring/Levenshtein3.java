package com.corso.checkstring;

import com.corso.standardwords.AlgorithmType;

public class Levenshtein3 extends Levenshtein{

	public Levenshtein3() {
		super(3);
	}

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Levenshtein3;
	}

}
