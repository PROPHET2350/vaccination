package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import com.challenge.vaccination.Repositories.UsersRepository;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServices {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;
    @Autowired
    private EmployeesDetailsRepository employeesDetailsRepository;
    @Autowired
    private UsersRepository usersRepository;

    public EmployeesServices(EmployeesRepository employeesRepository, VaccinationDetailsRepository vaccinationDetailsRepository, EmployeesDetailsRepository employeesDetailsRepository, UsersRepository usersRepository) {
        this.employeesRepository = employeesRepository;
        this.vaccinationDetailsRepository = vaccinationDetailsRepository;
        this.employeesDetailsRepository = employeesDetailsRepository;
        this.usersRepository = usersRepository;
    }

    public Employees CreateEmployee(Employees employee){
        return this.employeesRepository.save(employee);
    }
    public Employees searchById(String id){
        return this.employeesRepository.findByEmployeeid(id);
    }
    public void DeleteEmployee(String id){
        String userid = usersRepository.findByEmployeeEmployeeid(id).getUserid();
        String empdetails = employeesDetailsRepository.findByEmployeeEmployeeid(id).getEmployeesdetailsid();
        String vaccinationid = vaccinationDetailsRepository.findByEmployeesDetailsEmployeesdetailsid(empdetails).getVaccinationdetailsid();
        if (userid != null){
            usersRepository.deleteById(userid);
        }
        if (vaccinationid != null){
            vaccinationDetailsRepository.deleteById(vaccinationid);
        }
        if (empdetails != null){
            employeesDetailsRepository.deleteById(empdetails);
        }
      this.employeesRepository.deleteById(id);
    }
    public List<Employees> searchAll(){
        return employeesRepository.findAll();
    }
}
