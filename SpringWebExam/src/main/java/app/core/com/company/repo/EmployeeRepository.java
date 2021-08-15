package app.core.com.company.repo;

import java.util.List;

import app.core.com.company.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	List<Employee> findEmployeeByName(String name);
}
