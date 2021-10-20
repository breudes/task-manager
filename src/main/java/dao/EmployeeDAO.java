package dao;

import java.util.List;

import javax.persistence.EntityManager;

import domain.Employee;
import util.JPAUtil;

public class EmployeeDAO {
	
	public EmployeeDAO() {
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		EntityManager manager = JPAUtil.getEntityManager();
        return manager.createQuery("select e from Employee e order by id").getResultList();
	}
}
