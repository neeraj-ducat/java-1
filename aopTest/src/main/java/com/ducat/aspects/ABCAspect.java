package com.ducat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	@Before("pc1() || pc3()")
	public void preProcessing(JoinPoint jp) {
		System.out.println("Before advice is applied on "+jp.getSignature().getName()+"() method.");
	}
	/*@AfterReturning(pointcut="pc2()", returning="result")
	public void postProcessing(JoinPoint jp, Object result) {
		String method = jp.getSignature().getName()+"()";
		System.out.println("After advice is applied on "+method);
		System.out.println(result+" is received in the advice as return value.");
		result="failure";
		System.out.println("Return value is changed to failure by the advice.");
		System.out.println("Advice is completed.");
		
	}*/
	@AfterThrowing(pointcut="pc3()", throwing="error")
	public void errorProcessing(JoinPoint jp, Exception error) {
		String method = jp.getSignature().getName()+"()";
		System.out.println("Throws advice is applied on "+method+" because of "+error);
		
		
	}
	
	@Around("pc2()")
	public Object aroundProcessing(ProceedingJoinPoint pjp) throws Throwable {
		// pre processing
		String method = pjp.getSignature().getName()+"()";
		System.out.println("Around advice is invoked, bypassing the target method.");
		return "failure";
		/*System.out.println("Getting the "+method+" invoked.");
		// Getting the target method invoked.
		Object result = pjp.proceed();
		// post processing
		System.out.println(result+" is returned by the "+method);
		result="failure";
		System.out.println("Return value is changed to failure by the advice.");
		System.out.println("Advice is completed.");
		return result;*/
		
	}
}
