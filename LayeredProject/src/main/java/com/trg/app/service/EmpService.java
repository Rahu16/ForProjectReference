package com.trg.app.service;

import java.util.List;

import com.trg.app.entity.Employee;
import com.trg.app.exceptions.*;

public interface EmpService {
	
	Employee getEmployee(int id);
	void createNewEmployee(Employee e) throws EmployeeAlreadyExistsException;
	void raiseSalary(int eid, float salary) throws SalaryChangeException, EmployeeNotFoundException;
	Employee removeEmployee(int empId) throws EmployeeNotFoundException;
	List<Employee> getAllEmployee();
}
