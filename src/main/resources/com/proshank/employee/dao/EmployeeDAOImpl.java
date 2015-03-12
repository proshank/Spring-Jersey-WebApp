package com.proshank.employee.dao;

import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import com.proshank.employee.data.Employee;
import com.proshank.employee.dto.EmployeeDTO;

@Repository(value = "employeeDAO")
@Transactional
	
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceContext(unitName = "SPJLOCALUnit")
	@Qualifier(value = "persistenceManagerFactory")
	private EntityManager em;
	
	@Autowired
	private TransactionTemplate sharedTransactionTemplate;
	
	
	@Override
	public int addEmplyee(EmployeeDTO e) {
		/*SessionFactory spjSessionFactory = SPJSessionFactory
				.getSessionFactory();
		Session session = spjSessionFactory.openSession();
		session.beginTransaction();
		int id = (Integer) session.save(e);
		session.getTransaction().commit();
		return id;*/
		em.persist(e);
		return e.getId();
	}

	@Override
	public EmployeeDTO getEmplyee(int id) {
		/*SessionFactory spjSessionFactory = SPJSessionFactory
				.getSessionFactory();
		Session session = spjSessionFactory.openSession();
		session.beginTransaction();
		EmployeeDTO e = (EmployeeDTO) session.get(EmployeeDTO.class, id);
		session.close();*/
		EmployeeDTO e = em.find(EmployeeDTO.class, id);
		return e;
	}

	@Override
	public List<EmployeeDTO> getEmplyee(Employee e) {

		Query q = em.createQuery("from EmployeeDTO e where e.id = :employeeName");
		q.setParameter("employeeName", e.getId());
		q.setHint("org.hibernate.cacheable", true); 
		q.setHint("javax.persistence.cache.retrieveMod", "USE");
		
		Cache cache = em.getEntityManagerFactory().getCache();
		if (cache.contains(EmployeeDTO.class, e.getId())) {
			System.out.println("Cache is cached");  
		} 
		return q.getResultList();
	}

}
