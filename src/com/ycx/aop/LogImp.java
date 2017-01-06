package com.ycx.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
@Aspect
@Component
public class LogImp {
 	@Pointcut("execution(public String com.ycx.proxy.Hello.*(..))")
	public void declare(){
		
	}
	/*@Before("declare()")
	public void log(JoinPoint jo){
		String name = jo.getSignature().getName();
		System.out.println(name+"方法执行");
	}*/
	/*@Around(value="execution( public String com.ycx.aop.PushServiceImpl.*(..))")
	public void log2(JoinPoint jo){
		String name = jo.getSignature().getName();
		System.out.println(name+"方法执行完成");
	}
*/
	@Around(value="execution(public * com.ycx.proxy.Hello.sayHello2(..))")
	public void log3(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知进入方法");
		Object object = pjp.proceed();
		System.out.println("环绕通知退出方法");
	}
	
	public void sayHelloAopTest(){
		System.out.println("同一个类的AOP调用");
	}
	

}
