package com.example.ems_backend.service;

import com.example.ems_backend.exception.ResourceNotFounException;
import org.springframework.stereotype.Service;
import com.example.ems_backend.dto.*;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.entity.*;
import lombok.*;
import com.example.ems_backend.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee createEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(createEmployee);


	}

	@Override
	public EmployeeDto getEmployeeId(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFounException("Employee is not exists with given Id: " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFounException("Employee is not exists with given Id: " + employeeId));
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());

		Employee updatedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long employeId) {
		Employee employee = employeeRepository.findById(employeId).orElseThrow(()-> new ResourceNotFounException("Employee is not exists with given Id: " + employeId));
        employeeRepository.deleteById(employeId);
	}


}
