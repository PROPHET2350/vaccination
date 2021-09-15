package com.challenge.vaccination.Controllers;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Helpers.validations;
import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Services.EmployeesServices;
import com.challenge.vaccination.Services.UsersServices;
import com.challenge.vaccination.Services.VaccinationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class EmployeesController {

    @Autowired
    private final EmployeesServices employeesServices;
    @Autowired
    private final UsersServices usersServices;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final VaccinationDetailsService vaccinationDetailsService;

    public EmployeesController(EmployeesServices employeesServices, UsersServices usersServices, PasswordEncoder passwordEncoder, VaccinationDetailsService vaccinationDetailsService) {
        this.employeesServices = employeesServices;
        this.usersServices = usersServices;
        this.passwordEncoder = passwordEncoder;
        this.vaccinationDetailsService = vaccinationDetailsService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/v1/admin/employees")
    public List<Employees> searchAllBasicEmployees(){
        return employeesServices.searchAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/v1/admin/employees-complete-info")
    public List<VaccinationDetails> searchAllCompleteEmployees(){
        return vaccinationDetailsService.searchAllDetails();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/api/v1/admin/add-employee")
    public ResponseEntity<Employees> AddEmployee(@RequestParam Map<String, String> body){
        String id = UUID.randomUUID().toString();
        Employees employees = new Employees(id,body.get("dni"),body.get("name"),
                body.get("lastname"),body.get("mail"));
        if(validations.EmployeesValidation(employees)){
            return ResponseEntity.status(201).body(employeesServices.CreateEmployee(employees));
        }else{
            return ResponseEntity.status(400).body(null);
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/api/v1/admin/update-employee")
    public ResponseEntity<Employees> UpdateEmployee(@RequestParam Map<String, String> body){

        Employees employees = new Employees(body.get("id"),body.get("dni"),body.get("name"),
                body.get("lastname"),body.get("mail"));
        if(validations.EmployeesValidation(employees)){
            return ResponseEntity.status(201).body(employeesServices.CreateEmployee(employees));
        }else{
            return ResponseEntity.status(400).body(null);
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/api/v1/admin/change-employee-status")
    public Employees ChangeEmployeeStatus(@RequestParam Map<String, String> body){
        Employees employees = employeesServices.searchById(body.get("id"));
        employees.setStatus(true);
        String id = UUID.randomUUID().toString();
        Users us = new Users(id,employees.getLastname(),passwordEncoder.encode(employees.getDni())
                ,body.get("role"),employees);
        usersServices.CreateUser(us);
        return employeesServices.CreateEmployee(employees);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/api/v1/admin/delete-employee")
    public void DeleteEmployee(@RequestParam Map<String, String> body){
        employeesServices.DeleteEmployee(body.get("id"));
    }
}
