package com.javi.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	// setup pointcut declarations
	@Pointcut("execution(* com.javi.springdemo.controller.*.*(..)")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forControllerPackage()  {}
	
	@Pointcut("execution(* com.javi.springdemo.service.*.*(..)")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forServicePackage()  {}
	
	@Pointcut("execution(* com.javi.springdemo.dao.*.*(..)")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forDaoPackage()  {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forControllerPackage()")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forAppFlow()  {}
	
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for (Object tempArg : args) {
			myLogger.info("====>> argument: " + tempArg);
		}
		
		
	}
	
	// add @AfterReturning advice

}
