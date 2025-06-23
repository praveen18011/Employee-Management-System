package com.example.ems_backend.service;

import com.example.ems_backend.dto.*;

import java.util.List;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeId(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

	void deleteEmployee(Long employeId);
}
