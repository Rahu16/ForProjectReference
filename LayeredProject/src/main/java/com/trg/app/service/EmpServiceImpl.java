package com.trg.app.service;

import java.util.List;

import com.trg.app.dao.*;

import com.trg.app.entity.Employee;
import com.trg.app.exceptions.EmployeeAlreadyExistsException;
import com.trg.app.exceptions.EmployeeNotFoundException;
import com.trg.app.exceptions.SalaryChangeException;

public class EmpServiceImpl implements EmpService{
	
	EmpDao empl= new EmpDaoJpaImpl();
	
	@Override
	public Employee getEmployee(int id) {
		
		return empl.getEmployee(id);
	}

	@Override
	public void createNewEmployee(Employee e) throws EmployeeAlreadyExistsException {
		
		boolean create = empl.save(e);
		if(create == false) {
			throw new EmployeeAlreadyExistsException("Employee with Employee Id : "+e.getEmpId()+" already exists");
		}
		
	}

	@Override
	public void raiseSalary(int eid, float salary) throws SalaryChangeException,EmployeeNotFoundException {
		Employee emp = empl.getEmployee(eid);

		if(emp == null) {
			throw new EmployeeNotFoundException("What is this man! \n The Employee doesn't exist then how can you change the Salary!!");
			
		}
		else if(emp.getSalary()<salary) {
			throw new SalaryChangeException("Salary of Employee can't be reduced from previous Salary");
		}
		emp.setSalary(salary);
		
	}

	@Override
	public Employee removeEmployee(int empId) throws EmployeeNotFoundException {
		Employee emp = empl.getEmployee(empId);
		if(emp == null) {
			throw new EmployeeNotFoundException("Employee Does Not Exist with ID : "+empId);
		}
		Employee e = empl.delete(empId);
		return e;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empl.getAllEmplyee();
	}

}
