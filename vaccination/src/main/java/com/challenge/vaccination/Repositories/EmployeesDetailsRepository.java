package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.EmployeesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesDetailsRepository extends JpaRepository<EmployeesDetails,Long> {
}
