package com.corso.model;

import com.corso.checkstring.AlgorithmType;

public class AlgoResult implements Comparable<AlgoResult>{

	private int winrate;
	public AlgorithmType type;

	@Override
	public int compareTo(AlgoResult o) {
		return (this.winrate>o.winrate)?1:-1;
	}

}
