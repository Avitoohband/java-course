package app.core.com.company.beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private LocalDate endDate;

	public Job() {
	}

	public Job(long id, String description, LocalDate endDate) {
		this.id = id;
		this.description = description;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return  "job: desc=" + description +
				", endDate=" + endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Job job = (Job) o;
		return id == job.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}
