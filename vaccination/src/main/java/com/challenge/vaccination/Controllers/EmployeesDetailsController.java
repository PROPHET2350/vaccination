package com.challenge.vaccination.Controllers;

import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Services.EmployeesDetailsServices;
import com.challenge.vaccination.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
public class EmployeesDetailsController {

    @Autowired
    private final EmployeesDetailsServices employeesDetailsServices;
    @Autowired
    private final UsersServices usersServices;

    public EmployeesDetailsController(EmployeesDetailsServices employeesDetailsServices, UsersServices usersServices) {
        this.employeesDetailsServices = employeesDetailsServices;
        this.usersServices = usersServices;
    }

    @PostMapping("/api/v1/user/add-detail")
    public ResponseEntity<EmployeesDetails> AddEmployeeDetails(@RequestParam Map<String ,String >body){
        try {
            boolean state;
            if (Objects.equals(body.get("state"), "false")){
                state = false;
            }else{
                state = true;
            }
            Users us = usersServices.searchById(body.get("id"));
            Date bd = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("bd"));
            EmployeesDetails employeesDetails = new EmployeesDetails(UUID.randomUUID().toString(),bd
                    ,body.get("direction"),body.get("phone"),state,us.getEmployee());
            if (employeesDetailsServices.CreateDetail(employeesDetails) != null){
                return ResponseEntity.status(201).body(employeesDetailsServices.CreateDetail(employeesDetails));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(400).body(null);
    }
    @PostMapping("/api/v1/user/details")
    public ResponseEntity<EmployeesDetails> searchDetailByUserId(@RequestParam Map<String ,String > body){
        Users us = usersServices.searchById(body.get("id"));
        if(us != null){
            return ResponseEntity.status(201).body(employeesDetailsServices.searchByEmployeeId(us.getEmployee().getEmployeeid()));
        }else{
            return ResponseEntity.status(404).body(null);
        }
    }
}
