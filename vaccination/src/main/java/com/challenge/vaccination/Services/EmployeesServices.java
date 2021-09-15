package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServices {

    @Autowired
    private EmployeesRepository employeesRepository;

    public EmployeesServices(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }
    public Employees CreateEmployee(Employees employee){
        return this.employeesRepository.save(employee);
    }
    public Employees searchById(String id){
        return this.employeesRepository.findByEmployeeid(id);
    }
    public void DeleteEmployee(String id){
      this.employeesRepository.deleteById(id);
    }
    public List<Employees> searchAll(){
        return employeesRepository.findAll();
    }
}
