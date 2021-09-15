package com.challenge.vaccination.Controllers;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Services.EmployeesServices;
import com.challenge.vaccination.Services.VaccinationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    private VaccinationDetailsService employeesServices;

    public EmployeesController(VaccinationDetailsService employeesServices) {
        this.employeesServices = employeesServices;
    }
    @GetMapping("/e")
    public VaccinationDetails searchAllEmployees(){
        return employeesServices.findByEmployeeDetailsId(1L);
    }
}
