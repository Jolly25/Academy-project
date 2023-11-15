package com.corso.logging;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect 
public class LoggingAspect {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Pointcut("@annotation(com.corso.logging.LoggingAnnotations.LoginLog)")
	 public void generalPointcut() {}
	 
	 @Before("generalPointcut()")
	 public void generalBeforePointcut(JoinPoint joinPoint) {
		 	String message = joinPoint.getSignature().getName(); 
	        System.out.println(message);	 
	        
	        logger.info(message);
	 }
	
	
}
