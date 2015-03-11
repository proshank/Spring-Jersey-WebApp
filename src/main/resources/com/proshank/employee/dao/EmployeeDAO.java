package com.proshank.employee.dao;

import java.util.List;

import com.proshank.employee.data.Employee;
import com.proshank.employee.dto.EmployeeDTO;

public interface EmployeeDAO {
	public int addEmplyee(EmployeeDTO e);
	public EmployeeDTO getEmplyee(int id);
	public List<EmployeeDTO> getEmplyee(Employee e);
	
}
