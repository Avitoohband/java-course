package avi.core.services;


import avi.core.entities.Employee;
import avi.core.entities.Job;
import avi.core.repositories.EmployeeRepository;
import avi.core.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee emp){
       employeeRepository.save(emp);
    }
    public Employee findEmployeeById(long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }
    public List<Employee> findEmployeesByName(String name){
        return employeeRepository.findByName(name);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public List<Job> findAllJobs(){
        return jobRepository.findAll();
    }
    public List<Job> findJobsByEndDate(LocalDate date){
        return jobRepository.findByEndDate(date);
    }
    public List<Job> findByEndDateBetween(LocalDate start, LocalDate end){
        return jobRepository.findByEndDateBetween(start, end);
    }

}
