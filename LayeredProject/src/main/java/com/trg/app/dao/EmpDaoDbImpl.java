package com.trg.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;
import java.io.InputStream;

import com.trg.app.entity.Employee;


public class EmpDaoDbImpl implements EmpDao{
	
	Connection con;

	
	public EmpDaoDbImpl() {
		
		InputStream file = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties prop = new Properties();

		try {

			prop.load(file);	
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"),
											  prop.getProperty("user"),
											  prop.getProperty("password"));
			System.out.println("Connection Created");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}		
		
	}

	@Override
	public boolean save(Employee e) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1,e.getEmpId());
			ps.setString(2, e.getName());
			ps.setFloat(3, e.getSalary());
			ps.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Employee e) {
		try {
			PreparedStatement ps = con.prepareStatement("update employee set name =?, salary =? where empid = ?");
			ps.setInt(1,e.getEmpId());
			ps.setString(2, e.getName());
			ps.setFloat(3, e.getSalary());
			int x = ps.executeUpdate();
			if(x==0) {
				return false;
			}
			return true;
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			return false;
		}

	}

	@Override
	public Employee delete(int empId) {
		Employee e = getEmployee(empId);
		try {
			if(e==null) {
				return null;
			}
			PreparedStatement ps = con.prepareStatement("delete employee where empid = ?");
			ps.setInt(1,e.getEmpId());
			ps.executeUpdate();
			
			return e;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

	}

	@Override
	public Employee getEmployee(int empId) {
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from employee where empId=?");
			ps.setInt(1, empId);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				
				String name = rs.getString("name");
				float salary = rs.getFloat("salary");
				Employee e = new Employee(empId,name,salary);
				return e;
			}
			else {
				return null;
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Employee> getAllEmplyee() {
		ArrayList<Employee> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				float salary = rs.getFloat("salary");
				int empId = rs.getInt("empId");
				
				Employee e = new Employee(empId,name,salary);
				list.add(e);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
