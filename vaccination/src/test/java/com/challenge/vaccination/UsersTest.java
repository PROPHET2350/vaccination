package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import com.challenge.vaccination.Repositories.UsersRepository;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import com.challenge.vaccination.Services.EmployeesServices;
import com.challenge.vaccination.Services.UsersServices;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersTest {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;
    @Autowired
    private EmployeesDetailsRepository employeesDetailsRepository;
    @Autowired
    private UsersServices usersServices;

    @Test
    @Order(1)
    public void insertUser(){
        vaccinationDetailsRepository.deleteAll();
        employeesDetailsRepository.deleteAll();
        usersRepository.deleteAll();
        employeesRepository.deleteAll();
        Employees emp = new Employees("10","11","will","Smith","will@gmial.com");
        employeesRepository.save(emp);
        Users us = new Users("1","x","asd","USER",emp);
        usersServices.CreateUser(us);
        Assert.assertEquals(usersServices.searchById("1").getUsername(),us.getUsername());
        Assert.assertEquals(usersServices.searchById("1").getUserid(),us.getUserid());
        Assert.assertEquals(usersServices.searchById("1").getPassword(),us.getPassword());
        Assert.assertEquals(usersServices.searchById("1").getRole(),us.getRole());
    }
    @Test
    @Order(2)
    public void UpdateUser(){
        Employees emp = new Employees("10","11","will","Smith","will@gmial.com");
        employeesRepository.save(emp);
        Users us = new Users("1","xxxx","asdsss","USER",emp);
        usersServices.updateUser(us);
        Assert.assertEquals(usersServices.searchById("1").getUsername(),us.getUsername());
        Assert.assertEquals(usersServices.searchById("1").getUserid(),us.getUserid());
        Assert.assertEquals(usersServices.searchById("1").getPassword(),us.getPassword());
        Assert.assertEquals(usersServices.searchById("1").getRole(),us.getRole());
    }

}
