package com.employees.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.demo.dto.EmployeeDto;
import com.employees.demo.services.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	// Inject the EmployeeService here...
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")                            //    http://localhost:8081/emp/add
	public ResponseEntity<EmployeeDto> addEmp(@RequestBody EmployeeDto employeeDto){
		EmployeeDto creatEmp = employeeService.creatEmp(employeeDto);
		return new ResponseEntity<EmployeeDto>(creatEmp , HttpStatus.CREATED);
	}
    
	@GetMapping("/get")       //   http://localhost:8081/emp/get
	public ResponseEntity<List<EmployeeDto>> getAllEmpList(){
		List<EmployeeDto> listEmp = employeeService.getAll();
		return new ResponseEntity<List<EmployeeDto>>(listEmp , HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")                                                  //    http://localhost:8081/emp/update/1
	public ResponseEntity<EmployeeDto> modifyEmp(@PathVariable("id")Integer id ,@RequestBody EmployeeDto employeeDto){
		EmployeeDto updateEmp = employeeService.updateEmp(employeeDto, id);
		return new ResponseEntity<EmployeeDto>(updateEmp , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/del/{id}")                                  //   http://localhost:8081/emp/del/2
	public void deleteEmp(@PathVariable("id")Integer id ,@RequestBody EmployeeDto employeeDto){
		 employeeService.deleteEmp(id);

	}
	
	@GetMapping("/emailId/{email}")                     //   http://localhost:8081/emp/emailId/xyz@gmail.com
	public ResponseEntity<EmployeeDto> getViaEmail(@PathVariable("email") String email ){
		EmployeeDto byEmail = employeeService.getBYEmail(email);
		return new ResponseEntity<EmployeeDto>(byEmail , HttpStatus.OK);
		
	}
	@GetMapping("/occ/{occupation}")                     //   http://localhost:8081/emp/occ/software developer
	public ResponseEntity<List<EmployeeDto>> getViaOcc(@PathVariable("occupation") String occupation ){
		List<EmployeeDto> byOcc = employeeService.getAllByOccupation(occupation);
		return new ResponseEntity<List<EmployeeDto>>(byOcc , HttpStatus.OK);
		
	}
	@GetMapping("/address/{city}")                     //   http://localhost:8081/emp/address/mumbai
	public ResponseEntity<List<EmployeeDto>> getViaCity(@PathVariable("city") String city ){
		List<EmployeeDto> byCity = employeeService.getAllByCity(city);
		return new ResponseEntity<List<EmployeeDto>>(byCity , HttpStatus.OK);
		
	}
	
}
