package com.springtxn.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
//What code need to be there
public class CallTracker {
	
	@Pointcut("within(com.springtxn.service.*) || within(com.springtxn.repository.*)")
	public void logMethodPointcut() {

	}
	//when the logic should run before/ after / around

/*	@Before(value = "logMethodPointcut()")
	public void logBeforeMethodCall() {
		System.out.println("Method is starting ..");
	}
	
	@After(value = "logMethodPointcut()")
	public void logAfterMethodCall() {
		System.out.println("Method execution completed ..");
	}*/
	@Around("logMethodPointcut()")
	public Object LogBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		String name = proceedingJoinPoint.getSignature().getName();
		System.out.println("Method Start "+name);
		
		Object returnValue = proceedingJoinPoint.proceed();
		//System.out.println(returnValue);
		
		System.out.println("Method  completed .."+name);
		return returnValue;
		
	}
	
}
