package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.Task;
import util.JPAUtil;

public class TaskDAO {
	
	public TaskDAO() {
	}
	
	public void insertTask(Task task) {
		EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
        	transaction.begin();
            manager.persist(task);
            transaction.commit();
            manager.close();
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public Task updateTask(Long id, Task task) {
		 EntityManager manager = JPAUtil.getEntityManager();
	     EntityTransaction transaction = manager.getTransaction();
	     Task taskResult;

	     try {
	    	 transaction.begin();
	    	 taskResult = manager.merge(task);
		     transaction.commit();
		     manager.close();
		     
		     return taskResult;
	     } catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     return null;
	}
	
	public void deleteTask(Long id) {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> listTask() {
		EntityManager manager = JPAUtil.getEntityManager();
		
        return manager.createQuery("select t from Task t order by id").getResultList();
	}
}
