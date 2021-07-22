package avi.core.entities;

import java.util.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double salary;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Job> jobs;

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
        if (jobs == null){

        }
        return jobs;
    }
    public void addJob(Job jobToAdd){
        if(jobs == null){
            jobs = new ArrayList<>();
        }
        jobs.add(jobToAdd);
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        String jbs = "";
        for (Job job : jobs) {
            jbs += job +"\n";
        }
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", jobs:\n" + jbs +
                '}';
    }
}
