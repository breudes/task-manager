package bean.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.TaskDAO;
import domain.Task;

@Named
@ViewScoped
public class TaskBean implements Serializable{

	private static final long serialVersionUID = -2577003922676646324L;

	private Task task;
	private List<Task> tasks;
	private TaskDAO taskDAO;
	
	public TaskBean() {
	}
	
	public TaskBean(Task task, TaskDAO taskDAO) {
		this.task = task;
		this.taskDAO = taskDAO;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@PostConstruct
	public void init() {
		this.task = new Task();
		this.taskDAO = new TaskDAO();
	}
	
	public void saveTask() {
		taskDAO.insertTask(task);
		
		Messages.addGlobalInfo("Task saved successfully!");
	}
	
	public void deleteTask() {
		
	}
	
	public void listAllTasks() {
		
	}
}
