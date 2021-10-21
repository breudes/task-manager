package domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema="public")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable = false, length=50)
	private String name;
	
	@Column(name="birth_date", nullable = false)
	private LocalDate birthDate;
	
	@Column(name="role", length=20)
	private String role;
	
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	private List<Task> tasks;

	public Employee() {
	}

	public Employee(Long id, String name, LocalDate birthDate, String role, List<Task> tasks) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.role = role;
		this.tasks = tasks;
	}

	public Employee(Long id, String name, LocalDate birthDate, String role) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", role=" + role + ", tasks.size()=" + tasks.size() + "]";
	}
	
}
