package aspects.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

//	@Before("execution(public String aspects.model.Circle.getName())")
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {

		System.out.println(joinPoint.getTarget());
		
	}
	
	@AfterThrowing(pointcut="args(name)", throwing ="ex")
	public void exceptionAdvice(String name, RuntimeException ex) {
		
		System.out.println("Exception has been thrown");
	}
	
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceeding) {
		
		Object returnValue=null;
		
		try {
			System.out.println("before advice");
		//	proceeding.proceed();
			returnValue= proceeding.proceed();
			System.out.println("after returning");
		} catch (Throwable e) {
System.out.println("After Throwing");
		}
		System.out.println("after Finally");
		
		return returnValue;
	}
	
	
	@After("args(name)")
	public void stringArgument(String name) {
		System.out.println("A method that takes String argument: "+name);
	}

	@AfterReturning("args(name)")
	public void stringArgumentAfterReturning(String name) {
		System.out.println("AfterReturningString: "+name);
	}
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumentAfterReturning2(String name, Object returnString) {
		System.out.println("AfterReturningString2: "+name + " the output value is "+returnString);
	}
	
	
	/*
	 * @Before("execution(* get*(..))") public void secondAdvice() {
	 * 
	 * 
	 * System.out.println("second Advice "); }
	 */
	 

	@Pointcut("execution(* get*(..))")
	public void allGetters() {
		System.out.println("Advice run .Get method caled");
	}

//	@Pointcut("execution(* * aspects.model.Circle.*(..)")
	@Pointcut("within(aspects.model.Circle)")
	public void allCircleMethods() {

		System.out.println("All circle methods");
	}

}
