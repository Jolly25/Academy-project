package com.corso.checkstring;

import org.springframework.beans.factory.annotation.Autowired;

public class AlgorithmHandler {
	
	@Autowired
	private CheckString c1, c2, c3, c4, c5, c6, c7;
	
	private CheckString firstAlgo;

	public CheckString buildCheckString() {
		if (firstAlgo == null) {
			updateFirstAlgo();
		}
		return firstAlgo;
	}

	private void updateFirstAlgo() {
		c1.setNext(c2);
		c2.setNext(c3);
		c3.setNext(c4);
		c4.setNext(c5);
		c5.setNext(c6);
		c6.setNext(c7);
		
		firstAlgo = c1;
	}
}
