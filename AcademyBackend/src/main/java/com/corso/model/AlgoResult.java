package com.corso.model;

public class AlgoResult implements Comparable<AlgoResult>{

	private int winrate;

	@Override
	public int compareTo(AlgoResult o) {
		return (this.winrate>o.winrate)?1:-1;
	}

}
