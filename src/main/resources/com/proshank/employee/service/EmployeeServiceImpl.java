package com.proshank.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proshank.employee.dao.EmployeeDAO;
import com.proshank.employee.data.Employee;
import com.proshank.employee.dto.EmployeeDTO;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier(value="employeeDAO")
	EmployeeDAO employeeDAO;

	@Override
	public int addEmplyee(Employee e) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setCECId(e.getCec());
		employeeDTO.setfName(e.getFirstName());
		employeeDTO.setlName(e.getLastName());
		employeeDTO.setPassword(e.getPassword());
		int id = employeeDAO.addEmplyee(employeeDTO);
		return id;
	}

	@Override
	public Employee getEmployee(int id) {
		EmployeeDTO employeeDTO = employeeDAO.getEmplyee(id);
		Employee e = new Employee();
		e.setCec(employeeDTO.getCECId());
		e.setFirstName(employeeDTO.getfName());
		e.setLastName(employeeDTO.getlName());
		e.setPassword(employeeDTO.getPassword());
		e.setId(employeeDTO.getId());
		return e;
	}
	
	@Override
	public List<Employee> getEmployee(Employee e) {
		List<EmployeeDTO> employeeDTOList = employeeDAO.getEmplyee(e);
		List<Employee> employeeList = new ArrayList<Employee>();
		for(EmployeeDTO employeeDTO : employeeDTOList){
			Employee employee = new Employee();
			employee.setCec(employeeDTO.getCECId());
			employee.setFirstName(employeeDTO.getfName());
			employee.setLastName(employeeDTO.getlName());
			employee.setPassword(employeeDTO.getPassword());
			employee.setId(employeeDTO.getId());
			employeeList.add(employee);
		}
		return employeeList;
	}
	
}
