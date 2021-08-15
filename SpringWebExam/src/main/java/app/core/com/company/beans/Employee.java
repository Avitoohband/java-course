package app.core.com.company.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double salary;

	@OneToMany(cascade={
			CascadeType.PERSIST,
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH,
	},fetch=FetchType.EAGER)
	@JoinColumn(name = "employee")
	private List<Job> jobs= new ArrayList<>();

	public Employee() {
	}

	public Employee(long id, String name, double salary, List<Job> jobs) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.jobs = jobs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "Emp:" +
				"id=" + id +
				", name='" + name  +
				", sal=" + salary + '\n' +
				", jobs=" + jobs;

	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return id == employee.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
