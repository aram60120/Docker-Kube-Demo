package com.sandhata.docker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer empId;
    private String empName;
    private String empRole;
    private String empExp;
    private String empLoc;
	public Employee() {
		super();
	}
	public Employee(Integer empId, String empName, String empRole, String empExp, String empLoc) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRole = empRole;
		this.empExp = empExp;
		this.empLoc = empLoc;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public String getEmpExp() {
		return empExp;
	}
	public void setEmpExp(String empExp) {
		this.empExp = empExp;
	}
	public String getEmpLoc() {
		return empLoc;
	}
	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empRole=" + empRole + ", empExp=" + empExp
				+ ", empLoc=" + empLoc + "]";
	}

  

}
