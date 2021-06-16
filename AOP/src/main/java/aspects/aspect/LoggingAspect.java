package aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

//	@Before("execution(public String aspects.model.Circle.getName())")
	@Before("AllGetters()")
	public void LoggingAdvice() {
		
		System.out.println("Advice run .Get method caled");
	}
	
	@Before("execution(* get*(..))")
	public void secondAdvice() {
		
		System.out.println("second Advice ");
	}
	
	@Pointcut("execution(* get*(..))")
	public void AllGetters() {}
	
}
