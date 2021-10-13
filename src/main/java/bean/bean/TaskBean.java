package bean.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.TaskDAO;
import domain.Employee;
import domain.Task;
import enums.PriorityEnum;
import enums.StatusEnum;

@Named
@ViewScoped
public class TaskBean implements Serializable{

	private static final long serialVersionUID = -2577003922676646324L;

	private Task task;
	private List<Task> tasks;
	private TaskDAO taskDAO;
	
	private List<Employee> employees;
	private PriorityEnum[] priorities;
	private StatusEnum[] listStatus;
	
	public TaskBean() {
	}
	
	public TaskBean(Task task, TaskDAO taskDAO) {
		this.task = task;
		this.taskDAO = taskDAO;
	}
	
	public TaskBean(Task task, List<Task> tasks, TaskDAO taskDAO, List<Employee> employees, PriorityEnum[] priorities,
			StatusEnum[] listStatus) {
		this.task = task;
		this.tasks = tasks;
		this.taskDAO = taskDAO;
		this.employees = employees;
		this.priorities = priorities;
		this.listStatus = listStatus;
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
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public PriorityEnum[] getPriorities() {
		return priorities;
	}

	public void setPriorities(PriorityEnum[] priorities) {
		this.priorities = priorities;
	}

	public StatusEnum[] getListStatus() {
		return listStatus;
	}

	public void setListStatus(StatusEnum[] listStatus) {
		this.listStatus = listStatus;
	}

	@PostConstruct
	public void init() {
		this.task = new Task();
		this.taskDAO = new TaskDAO();
		
		this.priorities = PriorityEnum.values();
		this.listStatus = StatusEnum.values();
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
