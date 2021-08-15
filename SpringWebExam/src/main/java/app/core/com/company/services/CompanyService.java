package app.core.com.company.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import app.core.com.company.beans.Employee;
import app.core.com.company.beans.Job;
import app.core.com.company.exceptions.EmployeeNotFoundException;
import app.core.com.company.repo.EmployeeRepository;
import app.core.com.company.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private JobRepository jobRepo;
	
	public Long addEmployee(Employee e){
		empRepo.save(e);
		return e.getId();
	}
	public Employee getEmployee(long empId)throws EmployeeNotFoundException{
		Optional<Employee> optionalEmployee = empRepo.findById(empId);
		if(optionalEmployee.isPresent()){
			return optionalEmployee.get();
		}
		throw new EmployeeNotFoundException("No such Employee with id: " +empId);
	}
	public List<Employee> getEmployee(String name){
		return empRepo.findEmployeeByName(name);
	}
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	public List<Employee> getEmployees(String name) {
		return empRepo.findEmployeeByName(name);
	}
	public List<Job> getJobs(){
		return jobRepo.findAll();
	}
	public List<Job> getJobs(Date endDate){
		return jobRepo.findJobByEndDate(endDate);
	}
	public List<Job> getJobs(Date start, Date end){
		return jobRepo.findJobByEndDateBetween(start, end);
	}
}
