package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dao.EmployeeDAO;
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
	private EmployeeDAO employeeDAO;
		
	private List<Employee> employees;
	private PriorityEnum[] priorities;
	private StatusEnum[] listStatus;
	
	public TaskBean() {
	}
	
	public TaskBean(Task task, TaskDAO taskDAO, EmployeeDAO employeeDAO) {
		this.task = task;
		this.taskDAO = taskDAO;
		this.employeeDAO = employeeDAO;
	}

	public TaskBean(Task task, List<Task> tasks, TaskDAO taskDAO, EmployeeDAO employeeDAO, List<Employee> employees,
			PriorityEnum[] priorities, StatusEnum[] listStatus) {
		this.task = task;
		this.tasks = tasks;
		this.taskDAO = taskDAO;
		this.employeeDAO = employeeDAO;
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
		this.employeeDAO = new EmployeeDAO();
		
		this.priorities = PriorityEnum.values();
		this.listStatus = StatusEnum.values();
		this.employees = employeeDAO.listEmployee();
		
		listAllTasks();
	}
	
	public void refreshData() {
		task = new Task();
		listAllTasks();
	}
	
	public void saveTask() {
		task.setStatus(StatusEnum.IN_PROGRESS);
		boolean result = taskDAO.insertTask(task);
		
		if(result) {
			Messages.addGlobalInfo("Task saved successfully!");
		} else {
			Messages.addGlobalInfo("Error entering task!");
		}
		
		refreshData();
	}
	
	public void updateTask(Task currentTask) {
		task = currentTask;
		Task result = taskDAO.updateTask(task);
		
		if(result!=null) {
			Messages.addGlobalInfo("Task updated successfully!");
		} else {
			Messages.addGlobalInfo("Error while updating task!");
		}
		
		refreshData();
	}
	
	public void concludeTask(Task currentTask) {
		task = currentTask;
		task.setStatus(StatusEnum.CONCLUDED);
		Task result = taskDAO.updateTask(task);
		
		if(result!=null) {
			Messages.addGlobalInfo("Task concluded successfully!");
		} else {
			Messages.addGlobalInfo("Error while completing task!");
		}
		
		refreshData();
	}
	
	public void deleteTask(Task currentTask) {	
		task = currentTask;
		boolean result = taskDAO.deleteTask(task);
		
		if(result) {
			Messages.addGlobalInfo("Task deleted successfully!");
		} else {
			Messages.addGlobalInfo("Error removing task!");
		}
		
		refreshData();
	}
	
	public void listAllTasks() {
		this.tasks = taskDAO.listTask();
	}
}
