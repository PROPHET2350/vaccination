package com.challenge.vaccination.Controllers;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Services.EmployeesServices;
import com.challenge.vaccination.Services.VaccinationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesServices employeesServices;

    public EmployeesController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/v1/admin/employees")
    public List<Employees> searchAllBasicEmployees(){
        return employeesServices.searchAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/api/v1/admin/add-employee")
    public Employees AddEmployee(@RequestParam Map<String, String> body){
        String id = UUID.randomUUID().toString();
        Employees employees = new Employees(id,body.get("dni"),body.get("name"),
                body.get("lastname"),body.get("mail"));
        return employeesServices.CreateEmployee(employees);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/api/v1/admin/update-employee")
    public Employees UpdateEmployee(@RequestParam Map<String, String> body){

        Employees employees = new Employees(body.get("id"),body.get("dni"),body.get("name"),
                body.get("lastname"),body.get("mail"));
        return employeesServices.CreateEmployee(employees);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/api/v1/admin/delete-employee")
    public void DeleteEmployee(@RequestParam Map<String, String> body){
        employeesServices.DeleteEmployee(body.get("id"));
    }
}
