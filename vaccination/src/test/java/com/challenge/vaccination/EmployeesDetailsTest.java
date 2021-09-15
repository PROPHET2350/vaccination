package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import com.challenge.vaccination.Repositories.UsersRepository;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import com.challenge.vaccination.Services.EmployeesDetailsServices;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeesDetailsTest {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private EmployeesDetailsServices employeesDetailsServices;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;
    @Autowired
    private EmployeesDetailsRepository employeesDetailsRepository;

    @Test
    @Order(1)
    public void insertDetails() throws Exception{
        vaccinationDetailsRepository.deleteAll();
        employeesDetailsRepository.deleteAll();
        usersRepository.deleteAll();
        employeesRepository.deleteAll();
        Date bd = new SimpleDateFormat("dd/MM/yyyy").parse("07/11/2015");
        Employees emp = new Employees("10","11","will","Smith","will@gmial.com");
        employeesRepository.save(emp);
        EmployeesDetails emD = new EmployeesDetails("1", bd
                ,"calle","09",false,emp);
        employeesDetailsServices.CreateDetail(emD);
        Assert.assertEquals(employeesDetailsServices.searchByEmployeeId("10").getDirection(),emD.getDirection());
        Assert.assertEquals(employeesDetailsServices.searchByEmployeeId("10").getEmployeesdetailsid(),emD.getEmployeesdetailsid());
    }
    @Test
    @Order(2)
    public void FilterDetailsByState(){
        List<EmployeesDetails> details = employeesDetailsServices.searchByState(false);
        Assert.assertEquals(details.size(),1);
    }
}
