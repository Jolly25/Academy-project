package com.corso.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect 
public class LoggingAspect {

	 @Pointcut("@annotation(com.corso.logging.LoggingAnnotations.LoginLog)")
	 public void generalPointcut() {}
	 
	 @Before("generalPointcut()")
	 public void generalBeforePointcut() {
	        System.out.println("Un utente ha fatto il login");	 }
	
}
