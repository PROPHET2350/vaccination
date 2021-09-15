package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.EmployeesDetails;
import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Repositories.EmployeesDetailsRepository;
import com.challenge.vaccination.Repositories.EmployeesRepository;
import com.challenge.vaccination.Repositories.UsersRepository;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
class VaccinationApplicationTests {

	@Autowired
	private EmployeesRepository employeesRepository;
	@Autowired
	private EmployeesDetailsRepository employeesDetailsRepository;
	@Autowired
	private VaccinationDetailsRepository vaccinationDetailsRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Test
	public void contextLoads() {
		Employees c = new Employees(1l,"asd","asd","asd","asd");
		Users u = new Users(1L,"asd",passwordEncoder.encode("asd"),"ADMIN",c);
		//EmployeesDetails b = new EmployeesDetails(1L,Date.valueOf(LocalDate.now()),"asd","asd",true,c);
		//VaccinationDetails a = new VaccinationDetails(1l,"sino",Date.valueOf(LocalDate.now()),2,b);
		//System.out.println(this.vaccinationDetailsRepository.findByEmployeesDetailsEmployeesdetailsid(1L));
		System.out.println(usersRepository.save(u));
 	}

}
