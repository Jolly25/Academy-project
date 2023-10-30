package com.corso.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.beans.Beans;
import com.corso.checkstring.AlgorithmHandler;
import com.corso.checkstring.CheckString;


public class CheckStringTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(Beans.class);

		CheckString cs = (CheckString) factory.getBean("c1"); 
		AlgorithmHandler ah = (AlgorithmHandler) factory.getBean("ah"); 
		
		ah.buildCheckString();
		
		cs.check("Germanyy");
		
		
		
	}

}
