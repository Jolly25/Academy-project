package com.corso.checkstring;

public class Levenshtein1 extends Levenshtein{

	public Levenshtein1() {
		super(1);
	}

	@Override
	protected AlgorithmType getAlgo() {
		return AlgorithmType.Levenshtein1;
	}

}
