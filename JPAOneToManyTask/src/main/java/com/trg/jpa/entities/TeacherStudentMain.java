package com.trg.jpa.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherStudentMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Teacher t = new Teacher();
		t.setName("Sanjit Koley");
		t.setTeacherId(1);

		
		Student st = new Student();
		st.setStudentId(100);
		st.setName("Hasibul Mondal");
		st.setMarks(78);
		
		t.addStudents(st);
//		em.persist(st);
		

		
//		em.persist(t);
//		st.setTeacher(t);
//		em.persist(st);
		em.persist(t);

		em.getTransaction().commit();
		System.out.println("A new Student is added under a Teacher");
		em.close();
		
	}

}
