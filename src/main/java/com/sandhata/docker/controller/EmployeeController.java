package com.sandhata.docker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandhata.docker.model.Employee;
import com.sandhata.docker.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {

		ResponseEntity<String> resp = null;
		try {
			Integer id = service.saveEmployee(emp);
			resp = new ResponseEntity<String>(id + "Saved", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to save", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		try {
			List<Employee> list = service.getAllEmployee();
			resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to featch data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Optional<Employee> opt = service.getEmployeeById(id);
			if (opt.isPresent())
				resp = new ResponseEntity<Employee>(opt.get(), HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {

		ResponseEntity<String> resp = null;

		try {
			service.deleteEmployee(id);
			resp = new ResponseEntity<String>(id + "removed", HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to Delete", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

}
