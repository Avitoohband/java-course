package app.core.com.company;

import java.sql.Date;
import java.util.List;

import app.core.com.company.beans.Employee;
import app.core.com.company.beans.Job;
import app.core.com.company.services.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CompanyApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(CompanyApplication.class, args);
		
//		CompanyService companyService =ctx.getBean(CompanyService.class);
//		List<Employee> emps= companyService.getEmployees();
//		emps.forEach(System.out::println);
//
//		emps= companyService.getEmployee("Employee 1");
//		emps.forEach(System.out::println);
//
//		List<Job> jobs = companyService.getJobs(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+1000000000));
//		jobs.forEach(System.out::println);
//
//		jobs= companyService.getJobs(new Date(System.currentTimeMillis()));
//		jobs.forEach(System.out::println);
//
//		jobs= companyService.getJobs();
//		jobs.forEach(System.out::println);
	}

	public CompanyApplication() {
	}
}
