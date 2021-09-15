package com.challenge.vaccination;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Services.EmployeesServices;
import com.challenge.vaccination.Services.UsersServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UsersServices usersServices, EmployeesServices employeesServices){
		return args -> {
			Employees emp = employeesServices.CreateEmployee(new Employees("admin",
					"1234567890","notname","not","admin@admin.com"));
			usersServices.CreateUser(new Users("adminId","admin","root","ADMIN",emp));
		};
	}

}
