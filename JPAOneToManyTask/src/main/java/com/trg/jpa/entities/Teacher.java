package com.trg.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	
	@Id
	private int Id;
	private String name;
	
	@OneToMany(mappedBy="teacher",cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();
	
	public int getTeacherId() {
		return Id;
	}
	public void setTeacherId(int Id) {
		this.Id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + Id + ", name=" + name + ", students=" + students + "]";
	}
	
	public void addStudents(Student st){
		
		st.setTeacher(this);
		this.getStudents().add(st);
	}
	
	

}
