package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesDetailsServices {

    @Autowired
    private EmployeesDetailsRepository employeesDetailsRepository;

    public EmployeesDetailsServices(EmployeesDetailsRepository employeesDetailsRepository) {
        this.employeesDetailsRepository = employeesDetailsRepository;
    }

    public EmployeesDetails CreateDetail(EmployeesDetails employeesDetail){
        return this.employeesDetailsRepository.save(employeesDetail);
    }
    public List<EmployeesDetails> searchByState(boolean state){
        return this.employeesDetailsRepository.findByState(state);
    }
    public EmployeesDetails searchByEmployeeId(String id){
        return this.employeesDetailsRepository.findByEmployeeEmployeeid(id);
    }
    
}
