package com.test.springwithencache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

	    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationCacheManagerConfig.class);
	   
	    EmployeeDao obj = (EmployeeDao) context.getBean("employeeDao");

	    log.debug("Result : ", obj.findByEmployeeById(new Integer(1)));
	    log.debug("Result : ", obj.findByEmployeeById(new Integer(2)));
	    log.debug("Result : ", obj.findByEmployeeById(new Integer(3)));

	    // shut down the Spring context.
	    ((ConfigurableApplicationContext)context).close();

	}
}