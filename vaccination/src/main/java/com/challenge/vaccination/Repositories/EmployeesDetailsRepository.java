package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.Employees;
import com.challenge.vaccination.Models.EmployeesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDetailsRepository extends JpaRepository<EmployeesDetails,String> {
    EmployeesDetails findByEmployeeEmployeeid(String id);
}
