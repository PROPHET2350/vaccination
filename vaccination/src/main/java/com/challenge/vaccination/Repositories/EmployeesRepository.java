package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {
    
}
