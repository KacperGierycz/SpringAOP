package aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(public String aspects.model.Circle.getName())")
	public void LoggingAdvice() {
		
		System.out.println("Advice run .Get method caled");
	}
	
}
