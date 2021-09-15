package com.challenge.vaccination.Controllers;

import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Services.EmployeesDetailsServices;
import com.challenge.vaccination.Services.EmployeesServices;
import com.challenge.vaccination.Services.UsersServices;
import com.challenge.vaccination.Services.VaccinationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class VaccinationDetailsController {

    @Autowired
    private final UsersServices usersServices;
    @Autowired
    private  final EmployeesDetailsServices employeesDetailsServices;
    @Autowired
    private final EmployeesServices employeesServices;
    @Autowired
    private final VaccinationDetailsService vaccinationDetailsService;

    public VaccinationDetailsController(UsersServices usersServices, EmployeesDetailsServices employeesDetailsServices, EmployeesServices employeesServices, VaccinationDetailsService vaccinationDetailsService) {
        this.usersServices = usersServices;
        this.employeesDetailsServices = employeesDetailsServices;
        this.employeesServices = employeesServices;
        this.vaccinationDetailsService = vaccinationDetailsService;
    }

    @PostMapping("/api/v1/user/add-vaccination-details")
    public ResponseEntity<VaccinationDetails> AddVaccinationDetails(@RequestParam Map<String,String> body) throws Exception{
        Users us = usersServices.searchById(body.get("id"));
        EmployeesDetails ed = employeesDetailsServices.searchByEmployeeId(us.getEmployee().getEmployeeid());
        Date bd = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("date"));
        VaccinationDetails vaccinationDetails = new VaccinationDetails(UUID.randomUUID().toString(),
                body.get("type"),bd,Integer.parseInt(body.get("number")),ed);
        if (vaccinationDetailsService.CreateVaccinationDetails(vaccinationDetails) != null){
            return ResponseEntity.status(201).body(vaccinationDetailsService.CreateVaccinationDetails(vaccinationDetails));
        }else{
            return ResponseEntity.status(400).body(null);
        }
    }
    @PutMapping("/api/v1/user/update-vaccination-details")
    public ResponseEntity<VaccinationDetails> UpdateVaccinationDetails(@RequestParam Map<String,String> body) throws Exception{
        Users us = usersServices.searchById(body.get("id"));
        EmployeesDetails ed = employeesDetailsServices.searchByEmployeeId(us.getEmployee().getEmployeeid());
        Date bd = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("date"));
        VaccinationDetails vaccinationDetails = vaccinationDetailsService.findByEmployeeDetailsId(ed.getEmployeesdetailsid());
        VaccinationDetails newVaccinationDetails = new VaccinationDetails(vaccinationDetails.getVaccinationdetailsid(),
                body.get("type"),bd,Integer.parseInt(body.get("number")),ed);
        if (vaccinationDetailsService.CreateVaccinationDetails(newVaccinationDetails) != null){
            return ResponseEntity.status(201).body(vaccinationDetailsService.CreateVaccinationDetails(newVaccinationDetails));
        }else{
            return ResponseEntity.status(400).body(null);
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/api/v1/admin/filter-vaccination-type")
    public ResponseEntity<List<VaccinationDetails>> FilterByVaccinationType(@RequestParam Map<String,String> body){
        if(vaccinationDetailsService.filterByType(body.get("type")).isEmpty()){
            return ResponseEntity.status(400).body(null);
        }else{
            return ResponseEntity.status(201).body(vaccinationDetailsService.filterByType(body.get("type")));
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/api/v1/admin/filter-vaccination-date-range")
    public ResponseEntity<List<VaccinationDetails>> FilterByVaccinationDateRange(@RequestParam Map<String,String> body) throws Exception{
        Date First = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("First"));
        Date End = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("End"));
        if(vaccinationDetailsService.filterByDate(First,End).isEmpty()){
            return ResponseEntity.status(400).body(null);
        }else{
            return ResponseEntity.status(201).body(vaccinationDetailsService.filterByDate(First,End));
        }
    }
}
