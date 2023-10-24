package com.employees.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Optional<Employee> findByEmail(String Email);
	Optional<List<Employee>> findByOccupation(String occ);
	Optional<List<Employee>> findByCity(String city);

}
