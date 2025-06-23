package com.example.ems_backend.controller;

import org.springframework.web.bind.annotation.*;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;
	
	//Build Add Employee RestAPI//
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	//Build Get Employee RestAPI//
    @GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeId(employeeId);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}

	//Build Get All Employees RestAPI//
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	//Build Update Employee RestAPI//
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}

	//Build Delete Employee RestAPI//
    @DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee Deleted Successfully!");
	}
}
