package com.corso.checkstring;


import org.apache.commons.text.similarity.LevenshteinDistance;


public abstract class Levenshtein extends CheckStringWithList{
	
	private int threshold;
	
	public Levenshtein(int threshold) {
		this.threshold = threshold;
	}

	@Override
	protected boolean internalcheck(String s, String input) {
		LevenshteinDistance ld = new LevenshteinDistance();
		int distance = ld.apply(input, s);
		if(distance <= threshold) {
			return true;
		}
		return false;
	}
	
	
}

