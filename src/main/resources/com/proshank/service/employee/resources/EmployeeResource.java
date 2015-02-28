package com.proshank.service.employee.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.proshank.employee.data.Employee;

@Component
@Path("/users")
public class EmployeeResource {

	@GET
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee e1 = new Employee();
		e1.initializeDummy();
		employeeList.add(e1);
		return employeeList;
	}
}
