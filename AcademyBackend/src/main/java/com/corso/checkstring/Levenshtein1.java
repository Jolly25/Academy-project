package com.corso.checkstring;

import com.corso.model.Algorithm;

public class Levenshtein1 extends Levenshtein{

	public Levenshtein1() {
		super(1);
	}

	@Override
	protected Algorithm getAlgo() {
		return new Algorithm(AlgorithmType.Levenshtein1);
	}

}
