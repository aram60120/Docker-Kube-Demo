package com.sandhata.docker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandhata.docker.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	

}
