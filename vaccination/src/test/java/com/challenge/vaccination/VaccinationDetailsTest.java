package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import com.challenge.vaccination.Repositories.UsersRepository;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import com.challenge.vaccination.Services.VaccinationDetailsService;
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
public class VaccinationDetailsTest {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;
    @Autowired
    private EmployeesDetailsRepository employeesDetailsRepository;
    @Autowired
    private VaccinationDetailsService vaccinationDetailsService;

    @Test
    @Order(1)
    public void insertVaccinationDetails() throws Exception{
        vaccinationDetailsRepository.deleteAll();
        employeesDetailsRepository.deleteAll();
        usersRepository.deleteAll();
        employeesRepository.deleteAll();
        Date bd = new SimpleDateFormat("dd/MM/yyyy").parse("07/11/2015");
        Employees emp = new Employees("10","11","will","Smith","will@gmial.com");
        employeesRepository.save(emp);
        EmployeesDetails emD = new EmployeesDetails("1", bd
                ,"calle","09",false,emp);
        employeesDetailsRepository.save(emD);
        VaccinationDetails vaccinationDetails = new VaccinationDetails("1","b",bd,2,emD);
        VaccinationDetails newVD = vaccinationDetailsService.CreateVaccinationDetails(vaccinationDetails);
        Assert.assertEquals(newVD.getVaccinationdetailsid(),vaccinationDetails.getVaccinationdetailsid());
        Assert.assertEquals(newVD.getType(),vaccinationDetails.getType());
        Assert.assertEquals(newVD.getDoseNumber(),vaccinationDetails.getDoseNumber());
    }

    @Test
    @Order(2)
    public void filterVaccinationDetailsByType() throws Exception{
        List<VaccinationDetails> newVD = vaccinationDetailsService.filterByType("b");
        Assert.assertEquals(newVD.size(),1);
    }
    @Test
    @Order(2)
    public void filterVaccinationDetailsByDateRange() throws Exception{
        Date first = new SimpleDateFormat("dd/MM/yyyy").parse("06/11/2015");
        Date end = new SimpleDateFormat("dd/MM/yyyy").parse("08/11/2015");
        List<VaccinationDetails> newVD = vaccinationDetailsService.filterByDate(first,end);
        Assert.assertEquals(newVD.size(),1);
    }

}
