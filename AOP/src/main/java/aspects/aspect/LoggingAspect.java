package aspects.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name) {
		
		System.out.println("Exception has been thrown");
	}
	
	
	@After("args(name)")
	public void stringArgument(String name) {
		System.out.println("A method that takes String argument: "+name);
	}

	@AfterReturning("args(name)")
	public void stringArgumentAfterReturning(String name) {
		System.out.println("AfterReturning: "+name);
	}
	
	
	/*
	 * @Before("execution(* get*(..))") public void secondAdvice() {
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
