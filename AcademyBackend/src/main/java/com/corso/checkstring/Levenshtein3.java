package com.corso.checkstring;

import com.corso.model.Algorithm;

public class Levenshtein3 extends Levenshtein{

	public Levenshtein3() {
		super(3);
	}

	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Levenshtein3);
	}

}
