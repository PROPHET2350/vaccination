package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,String> {
    Employees findByEmployeeid(String id);
}
