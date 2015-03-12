package com.proshank.employee.resources;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.proshank.employee.data.Employee;
import com.proshank.employee.service.EmployeeService;

@Component
@Path("/employees")
public class EmployeeResource {
	@Autowired
	@Qualifier(value="employeeService")
	EmployeeService employeeService;

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
		int employeeID = Integer.parseInt(id);
		Employee e = employeeService.getEmployee(employeeID);
		return e;
	}

	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@QueryParam("id") String id,@QueryParam("name") String name) {
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
	public List<Employee> employeeSearch(MultivaluedMap<String, String> form) {
		Employee e1 = new Employee();
		e1.setId(Integer.parseInt(form.getFirst("id")));
		e1.setFirstName(form.getFirst("name"));
		List<Employee> elist = employeeService.getEmployee(e1);
 		return elist;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee e) {
		int id = employeeService.addEmplyee(e);
		e.setId(id);
		return e;
	}

}
