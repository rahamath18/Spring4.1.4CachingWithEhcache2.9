package com.test.springwithencache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Cacheable(value="employeeFindCache", key="#id")
	public Employee findByEmployeeById(Integer id) {
		
		slowQuery(5000L);
		
		System.out.println("findByEmployeeById is running...");
		
		if(id == 1)
			return new Employee(new Integer(1),"Gold Smith",new Double(3000.00));
		
		if(id == 2)
			return new Employee(new Integer(2),"Mr John",new Double(4000.00));
		
		if(id == 3)
			return new Employee(new Integer(3),"Ms Alisa",new Double(5000.00));
		
		return null;
	}

	private void slowQuery(long seconds){
	    try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
	}
}