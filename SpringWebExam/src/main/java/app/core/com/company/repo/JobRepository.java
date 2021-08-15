package app.core.com.company.repo;

import java.sql.Date;
import java.util.List;

import app.core.com.company.beans.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job,Long>{
	List<Job> findJobByEndDate(Date endDate);
	List<Job> findJobByEndDateBetween(Date startDate, Date endDate);
}
