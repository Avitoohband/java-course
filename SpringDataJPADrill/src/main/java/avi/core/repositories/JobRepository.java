package avi.core.repositories;

import avi.core.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
    List<Job> findByEndDate(LocalDate date);
    List<Job> findByEndDateBetween(LocalDate start, LocalDate end);
}
