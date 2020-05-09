package com.ducat.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ABCAspect {

	// Pointcut definitions
	@Pointcut("execution(* com.ducat.beans.ABC.a(..))")
	public void pc1() {}
	
	@Pointcut("execution(* com.ducat.beans.ABC.b(..))")
	public void pc2() {}
	
	@Pointcut("execution(* com.ducat.beans.ABC.c(..))")
	public void pc3() {}
	
	// Advices definitions
	@Before("pc1()")
	public void preProcessing() {
		System.out.println("Before advice is applied.");
	}
}
