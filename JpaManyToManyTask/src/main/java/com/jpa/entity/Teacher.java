package com.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
public class Teacher {
	
	@Id
	private int id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Teacher_Student", joinColumns = { @JoinColumn(name = "teacher_id")}, inverseJoinColumns = { @JoinColumn(name = "student_id")})
	private List<Student> allStudents = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getAllStudents() {
		return allStudents;
	}

	public void setAllStudents(List<Student> allStudents) {
		this.allStudents = allStudents;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", allStudents=" + allStudents + "]";
	} 
	
	public void addStudent(Student s) {
		this.getAllStudents().add(s);
	}
	
	
}
