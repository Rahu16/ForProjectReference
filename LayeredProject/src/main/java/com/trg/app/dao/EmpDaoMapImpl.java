package com.trg.app.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trg.app.entity.Employee;

public class EmpDaoMapImpl implements EmpDao{
	
	Map<Integer, Employee>  database = new HashMap<>();
	
	public EmpDaoMapImpl() {
		database.put(100, new Employee(100,"Kiran",8000));
		database.put(200, new Employee(200,"Simran",18000));
		database.put(300, new Employee(300,"Rohan",14000));
		database.put(400, new Employee(400,"Selim",13000));
		database.put(500, new Employee(500,"Mohit",16000));
	}
	
	@Override
	public boolean save(Employee e) {
		
		if (database.containsKey(e.getEmpId())){
			return true;
		}
		else {
			database.put(e.getEmpId(),e);
			return false;
		}
	}

	@Override
	public boolean update(Employee e) {
		
		if (database.containsKey(e.getEmpId())){
		
			database.put(e.getEmpId(), e);
		
			return true;
		}	
		return false;
	}
		

	@Override
	public Employee delete(int empId) {
		
		Employee e = database.get(empId);
		if(e != null) {
			database.remove(empId);
			return e;
		}
		return null;
	}

	@Override
	public Employee getEmployee(int empId) {
		if(database.containsKey(empId)) {
			return database.get(empId);
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmplyee() {
		
		Collection<Employee> employeeCollection = database.values();
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		employeeList.addAll(employeeCollection);
		return employeeList;
		
		
	
	}

}
