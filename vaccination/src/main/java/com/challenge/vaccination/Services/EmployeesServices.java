package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServices {

    @Autowired
    private EmployeesRepository employeesRepository;

    public EmployeesServices(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }
    public void CreateEmployee(Employees employee){
        this.employeesRepository.save(employee);
    }
    public void UpdateEmployee(Employees employee){
        this.employeesRepository.save(employee);
    }
    public void DeleteEmployee(Employees employee){
        this.employeesRepository.delete(employee);
    }
    public List<Employees> searchAll(){
        return  employeesRepository.findAll();
    }
}
