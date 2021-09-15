package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void UpdateDetail(EmployeesDetails employeesDetail){
        this.employeesDetailsRepository.save(employeesDetail);
    }
    public void DeleteDetail(EmployeesDetails employeesDetail){
        this.employeesDetailsRepository.delete(employeesDetail);
    }
    public EmployeesDetails searchByEmployeeId(String id){
        return this.employeesDetailsRepository.findByEmployeeEmployeeid(id);
    }
    
}
