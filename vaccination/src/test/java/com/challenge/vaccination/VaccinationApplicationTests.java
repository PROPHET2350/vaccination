package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
class VaccinationApplicationTests {

	@Autowired
	private EmployeesRepository employeesRepository;
	@Autowired
	private EmployeesDetailsRepository employeesDetailsRepository;
	@Test
	public void contextLoads() {

		Employees a = new Employees(1L,"45","asd","asd","asd");
		//EmployeesDetails b = new EmployeesDetails(1L, Date.valueOf(LocalDate.now()),"asd","189",false,a);
		System.out.println(this.employeesDetailsRepository.findByEmployeeEmployeeid(1L));
 	}

}
