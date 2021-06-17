package aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

//	@Before("execution(public String aspects.model.Circle.getName())")
	@Before("allGetters() || allCircleMethods()")
	public void LoggingAdvice() {

		System.out.println("before Allg and allC");
	}

	
	  @Before("execution(* get*(..))") public void secondAdvice() {
	  
		  System.out.println("second Advice "); }
	 

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
