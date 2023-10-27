package com.corso.checkstring;

public abstract class AlgorithmHandler {
	
	private static CheckString firstAlgo;

	public static CheckString buildCheckString() {
		if (firstAlgo == null) {
			updateFirstAlgo();
		}
		return firstAlgo;
	}

	private static void updateFirstAlgo() {
		CheckString c1 = new MatchCheckString();
		CheckString c2 = new Contained();
		c1.setNext(c2);
		CheckString c3 = new Contains();
		c2.setNext(c3);
		CheckString c4 = new Levenshtein(2);
		c3.setNext(c4);
		
		firstAlgo = c1;
	}
}
