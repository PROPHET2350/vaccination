package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import com.challenge.vaccination.Repositories.UsersRepository;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import com.challenge.vaccination.Services.EmployeesServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeesTest {

    @Autowired
    private EmployeesServices employeesServices;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;
    @Autowired
    private EmployeesDetailsRepository employeesDetailsRepository;

    @Test
    @Order(1)
    public void insertCorrectEmployeess(){
        vaccinationDetailsRepository.deleteAll();
        employeesDetailsRepository.deleteAll();
        usersRepository.deleteAll();
        employeesRepository.deleteAll();
        List<Employees> employees = new ArrayList<>();
        employees.add(new Employees("1","11","will","Smith","will@gmial.com"));
        employees.add(new Employees("2","22","Brad","Pitt","brad@gmial.com"));
        employees.add(new Employees("3","33","Jeniffer","lopez","jlo@gmial.com"));
        employees.add(new Employees("4","44","Lionel","Messi","dios@gmial.com"));
        for (Employees emp: employees) {
            employeesServices.CreateEmployee(emp);
        }
        Assert.assertEquals(employees.stream().count(),employeesServices.searchAll().stream().count());
    }
    @Test
    @Order(2)
    public void UpdateEmployee(){
        Employees emp = new Employees("1","11","william","Smith","will@gmial.com");
        employeesServices.CreateEmployee(emp);
        Assert.assertNotEquals(emp,employeesServices.searchById("1"));
    }
    @Test
    @Order(3)
    public void DeleteEmployeeTest(){
        employeesServices.DeleteEmployee("1");
        Assert.assertEquals(employeesServices.searchById("1"),null);
    }
}
