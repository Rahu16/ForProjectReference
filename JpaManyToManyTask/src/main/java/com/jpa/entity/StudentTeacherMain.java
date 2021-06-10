package com.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentTeacherMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Student st  = new Student();
		st.setId(100);
		st.setName("Hasibul Mondal");
		st.setMarks(85);
		
//		em.persist(st);
		
		Student st1  = new Student();
		st1.setId(200);
		st1.setName("Amit Halder");
		st1.setMarks(90);
		
//		em.persist(st1);
		
		Student st2  = new Student();
		st2.setId(300);
		st2.setName("Rahul Ghosh");
		st2.setMarks(95);
		
//		em.persist(st2);
		
		Teacher t = new Teacher();
		
		t.setId(1);
		t.setName("Jahor Mukherjee");
		
		t.addStudent(st);
		t.addStudent(st2);
		
		em.persist(t);

		
		
		Teacher t1 = new Teacher();
		
		t1.setId(2);
		t1.setName("Sandeep Kumer");
		
		t1.addStudent(st1);
		
		em.persist(t1);
		
	
//		
//		
//		Student s =  em.find(Student.class, 100);
//		
//		System.out.println(s);
		System.out.println("jksan");
		
		em.getTransaction().commit();
		em.close();
		
	}

}
