package com.employees.demo.services;

import java.util.List;

import com.employees.demo.dto.EmployeeDto;

public interface EmployeeService {
	
	//Create new employee's entry
	EmployeeDto creatEmp(EmployeeDto employeeDto);
	
	//update employee's data
	EmployeeDto updateEmp(EmployeeDto employeeDto , Integer id);
	
	//delete employee
	void deleteEmp(Integer id);
	
	//get list of all employees
	List<EmployeeDto> getAll();
	
	//find employee by id
	EmployeeDto getBYId(Integer id);

	//find employee by email
	EmployeeDto getBYEmail(String email);
	
	//find employee by his/her occupation
	List<EmployeeDto> getAllByOccupation(String occ);

	////find employee by his/her city
	List<EmployeeDto> getAllByCity(String city);
}
