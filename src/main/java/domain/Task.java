package domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enums.PriorityEnum;
import enums.StatusEnum;

@Entity
@Table(name = "task", schema="public")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", nullable = false, length=50)
	private String title;
	
	@Column(name="description", nullable = false, length=100)
	private String description;
	
	@ManyToOne
    @JoinColumn(name="tasks")
	private Employee employee;
	
	@Column(name="priority", nullable = false)
	private PriorityEnum priority;
	
	@Column(name="deadline", nullable = false)
	private LocalDate deadline;
	
	@Column(name="status", nullable = false)
	private StatusEnum status;

	public Task() {
	}

	public Task(Long id, String title, String description, Employee employee, PriorityEnum priority, LocalDate deadline,
			StatusEnum status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.employee = employee;
		this.priority = priority;
		this.deadline = deadline;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", employee=" + employee
				+ ", priority=" + priority + ", deadline=" + deadline + ", status=" + status + "]";
	}
	
}
