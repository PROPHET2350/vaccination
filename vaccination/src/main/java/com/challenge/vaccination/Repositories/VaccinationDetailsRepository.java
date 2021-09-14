package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.VaccinationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationDetailsRepository extends JpaRepository<VaccinationDetails,Long> {
}
