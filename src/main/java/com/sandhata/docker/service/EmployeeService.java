package com.sandhata.docker.service;

import java.util.List;
import java.util.Optional;

import com.sandhata.docker.model.Employee;

public interface EmployeeService {
	public Integer saveEmployee(Employee e);

	public List<Employee> getAllEmployee();

	public Optional<Employee> getEmployeeById(Integer id);

	public void deleteEmployee(Integer id);

}
