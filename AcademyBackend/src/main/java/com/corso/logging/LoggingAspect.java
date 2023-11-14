package com.corso.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect 
public class LoggingAspect {

	 @Pointcut("within(com.corso.controller..*)")
	 public void generalPointcut() {}
	 
	 @Before("generalPointcut()")
	 public void generalBeforePointcut() {
	        System.out.println("SIamo nel before dell pointcut");	 }
	
}
