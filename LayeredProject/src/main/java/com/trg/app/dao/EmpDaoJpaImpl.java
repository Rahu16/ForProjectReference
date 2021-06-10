package com.trg.app.dao;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.trg.app.entity.Employee;

public class EmpDaoJpaImpl implements EmpDao{
	
	EntityManager em;
	

	
	public EmpDaoJpaImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		em = emf.createEntityManager();
	}

	@Override
	public boolean save(Employee e) {
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			return true;

		} catch (EntityExistsException ex) {
			return false;
		}
	}

	@Override
	public boolean update(Employee e) {
		
		if(e != null) {
			
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();		
			em.close();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Employee delete(int empId) {
		
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e!= null) {
			em.remove(e);
			em.getTransaction().commit();
			
			return e;
		}
		
		return null;
	}

	@Override
	public Employee getEmployee(int empId) {
		
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, empId);
		
		em.getTransaction().commit();		
		return e;

	}

	@Override
	public List<Employee> getAllEmplyee() {
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Employee e");
		
		List<Employee> list = q.getResultList();
		
		return list;
	}

}
