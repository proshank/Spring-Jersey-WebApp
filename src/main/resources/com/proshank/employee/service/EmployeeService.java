package com.proshank.employee.service;

import java.util.List;

import com.proshank.employee.data.Employee;

public interface EmployeeService {
	public int addEmplyee(Employee e);
	public Employee getEmployee(int id);
	public List<Employee> getEmployee(Employee e);
}
