package com.javi.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	// setup pointcut declarations
	@Pointcut("execution(* com.javi.springdemo.controller.*.*.(..)")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forControllerPackage()  {}
	
	@Pointcut("execution(* com.javi.springdemo.service.*.*.(..)")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forServicePackage()  {}
	
	@Pointcut("execution(* com.javi.springdemo.dao.*.*.(..)")// * : Match on any CLASS in the package. * : match on any METHOD in the class. .. : Match on any number of arguments
	private void forDaoPackage()  {}
	
	
	// add @Before advice
	
	// add @AfterReturning advice

}
