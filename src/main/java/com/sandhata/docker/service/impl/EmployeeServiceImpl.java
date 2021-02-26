package com.sandhata.docker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandhata.docker.model.Employee;
import com.sandhata.docker.repo.EmployeeRepo;
import com.sandhata.docker.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Integer saveEmployee(Employee e) {

		return repo.save(e).getEmpId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {

		repo.deleteById(id);
	}

}
