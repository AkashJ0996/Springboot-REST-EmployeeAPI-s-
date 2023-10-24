package com.employees.demo.dto;

import com.employees.demo.entity.Employee;
import com.employees.demo.entity.Employee.EmployeeBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDto {
	

	private String name;
	private String email;
	private int age;
	private String occupation ;
	private String mobile;
	private String city;
	
	
	
}
