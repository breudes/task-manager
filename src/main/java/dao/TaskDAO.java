package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.Task;
import util.JPAUtil;

public class TaskDAO {
	
	public TaskDAO() {
	}
	
	public boolean insertTask(Task task) {
		EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
        	transaction.begin();
            manager.persist(task);
            transaction.commit();
            manager.close();
            return true;
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return false;
	}
	
	public Task updateTask(Task task) {
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
	
	public boolean deleteTask(Task task) {
		EntityManager manager = JPAUtil.getEntityManager();
	    EntityTransaction transaction = manager.getTransaction();

	    try {
	    	transaction.begin();
	    	manager.remove(manager.find(Task.class,task.getId()));
		    transaction.commit();
		    manager.close();
		  
		    return true;
	    } catch(Exception e) {
	    	 e.printStackTrace();
	    }
	    return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> listTask() {
		EntityManager manager = JPAUtil.getEntityManager();
        return manager.createQuery("SELECT t FROM Task t ORDER BY id").getResultList();
	}
	
	public Task getTask(Long id) {
		EntityManager sessao = JPAUtil.getEntityManager();
		return sessao.find(Task.class, id);
	}
}
