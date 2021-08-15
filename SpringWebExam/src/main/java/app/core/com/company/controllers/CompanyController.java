package app.core.com.company.controllers;


import app.core.com.company.beans.Employee;
import app.core.com.company.exceptions.CompanySystemException;
import app.core.com.company.exceptions.EmployeeNotFoundException;
import app.core.com.company.responses.CompanySystemResponse;
import app.core.com.company.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(path = "get-one/{employeeId}" , produces = "application/json")
    public Employee getOne(@PathVariable long employeeId) throws EmployeeNotFoundException {
        return companyService.getEmployee(employeeId);
    }
    @GetMapping(path = "get-all" , produces = "application/json")
    public List<Employee> getAll(){
        return companyService.getEmployees();
    }
    @GetMapping(path = "get-all-names" , produces = "application/json")
    public List<Employee> getAll(@RequestParam String name){
        return companyService.getEmployees(name);
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Long add(@RequestBody Employee employee){
        return companyService.addEmployee(employee);
    }
    @ExceptionHandler
    private ResponseEntity<CompanySystemResponse> exceptionHandler(CompanySystemException e){
        CompanySystemResponse error = new CompanySystemResponse();
        error.setMsg(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
