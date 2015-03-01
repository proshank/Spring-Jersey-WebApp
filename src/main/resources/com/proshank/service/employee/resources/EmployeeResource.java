package com.proshank.service.employee.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Component;

import com.proshank.employee.data.Employee;

@Component
@Path("/employees")
public class EmployeeResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee e1 = new Employee();
		e1.initializeDummy();
		employeeList.add(e1);
		return employeeList;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam(value = "id") String id) {
		Employee e1 = new Employee();
		e1.initializeDummy();
		e1.setCec(id);
		return e1;
	}
	
	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@QueryParam("id") String id, @QueryParam("name") String name ) {
		Employee e1 = new Employee();
		e1.initializeDummy();
		e1.setCec(id);
		e1.setFirstName(name);
		return e1;
	}
	
	@POST
	@Path("/search")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee searchEmployee(MultivaluedMap<String, String> form) {
		Employee e1 = new Employee();
		e1.initializeDummy();
		e1.setCec(form.getFirst("id"));
		e1.setFirstName(form.getFirst("name"));
		return e1;
	}
	
	
}
