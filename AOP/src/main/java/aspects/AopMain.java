package aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aspects.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeServiece = ctx.getBean("shapeService", ShapeService.class);
		shapeServiece.getCircle().setName("Dumy name");
		System.out.println(shapeServiece.getCircle().getName());
		
//		System.out.println(shapeServiece.getTriangle().getName());
	}

}
