package com.corso.checkstring;

import com.corso.model.Algorithm;

public class Levenshtein2 extends Levenshtein{

	public Levenshtein2() {
		super(2);
	}

	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Levenshtein2);
	}

}
