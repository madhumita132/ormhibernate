package springconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springconfiguration.resources.MyConfiguration;



public class Tester {

	public static void main(String[] args) {
		ApplicationContext ctc=new AnnotationConfigApplicationContext(MyConfiguration.class);
		Employeecon e=(Employeecon)ctc.getBean("employee");
		e.display();

	}

}
