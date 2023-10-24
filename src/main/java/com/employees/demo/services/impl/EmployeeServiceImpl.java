package com.employees.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.demo.dto.EmployeeDto;
import com.employees.demo.entity.Employee;
import com.employees.demo.repository.EmployeeRepository;
import com.employees.demo.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	@Override
	public EmployeeDto creatEmp(EmployeeDto employeeDto) {
		
		//Dto to entity conversion
        Employee e = dtoToEntity(employeeDto);
        // saving all information 
        Employee save = repository.save(e);
        // entity to dto
        EmployeeDto savedto = entityTodto(save);
		return savedto;
	}

	@Override
	public EmployeeDto updateEmp(EmployeeDto employeeDto , Integer id) {
		
		Employee e = repository.findById(id).orElseThrow(()->new RuntimeException("Employee Id not found"));
		e.setName(employeeDto.getName());
		e.setAge(employeeDto.getAge());
		e.setEmail(employeeDto.getEmail());
		e.setMobile(employeeDto.getMobile());
		e.setCity(employeeDto.getCity());
		e.setOccupation(employeeDto.getOccupation());
		
		Employee emp = repository.save(e);
		EmployeeDto dto = entityTodto(emp);
		return dto;
	}

	@Override
	public void deleteEmp(Integer id) {
		
		  Employee e = repository.findById(id).orElseThrow(()->new RuntimeException("Employee Id not found"));
		  repository.delete(e);
		
	}

	@Override
	public List<EmployeeDto> getAll() {
		List<Employee> findAll = repository.findAll();
		List<EmployeeDto> listOfEmployee = findAll.stream().map(emp -> entityTodto(emp)).collect(Collectors.toList());
		return listOfEmployee;
	}

	@Override
	public EmployeeDto getBYId(Integer id) {
		Employee empUsingId = repository.findById(id).orElseThrow(()->new RuntimeException("Employee Id not found"));
		EmployeeDto dto = entityTodto(empUsingId);
		return dto;
	}

	@Override
	public EmployeeDto getBYEmail(String email) {
		Employee empUsingEmail = repository.findByEmail(email).orElseThrow(()->new RuntimeException("Employee with this email not found"));
		EmployeeDto dto = entityTodto(empUsingEmail);
		return dto;
	}

	@Override
	public List<EmployeeDto> getAllByOccupation(String occ) {
	List<Employee> listUsingOcc = repository.findByOccupation(occ).orElseThrow(()->new RuntimeException("Employee with this occupation not found"));
		List<EmployeeDto> dto = listUsingOcc.stream().map(emp -> entityTodto(emp)).collect(Collectors.toList());
	return dto;
	}
	
	public List<EmployeeDto> getAllByCity(String city) {
		List<Employee> listUsingOcc = repository.findByCity(city).orElseThrow(()->new RuntimeException("Employee with this city not found"));
			List<EmployeeDto> dto = listUsingOcc.stream().map(emp -> entityTodto(emp)).collect(Collectors.toList());
		return dto;
		}
	
	//dto to entity conversion
	public Employee dtoToEntity(EmployeeDto employeeDto) {
		Employee e = Employee.builder()
				.name(employeeDto.getName())
				.age(employeeDto.getAge())
				.email(employeeDto.getEmail())
				.mobile(employeeDto.getMobile())
				.city(employeeDto.getCity())
				.occupation(employeeDto.getOccupation()).build();
				
				return e ;
	}
	
	//entity to DTO(Data transfer object)
	
    public EmployeeDto entityTodto(Employee employee) {
		
	   EmployeeDto dto= EmployeeDto.builder()
				.name(employee.getName())
				.age(employee.getAge())
				.email(employee.getEmail())
				.mobile(employee.getMobile())
				.city(employee.getCity())
				.occupation(employee.getOccupation()).build();
				
				return dto;
	}

	

}
