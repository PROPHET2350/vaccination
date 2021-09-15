package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.VaccinationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VaccinationDetailsRepository extends JpaRepository<VaccinationDetails,String> {
    VaccinationDetails findByEmployeesDetailsEmployeesdetailsid(String id);
    List<VaccinationDetails> findByType(String type);
    List<VaccinationDetails> findByVaccinationDateBetween(Date first, Date end);
}
