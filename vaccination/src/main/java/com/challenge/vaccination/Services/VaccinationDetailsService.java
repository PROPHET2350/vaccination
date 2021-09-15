package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationDetailsService {

    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;

    public VaccinationDetailsService(VaccinationDetailsRepository vaccinationDetailsRepository) {
        this.vaccinationDetailsRepository = vaccinationDetailsRepository;
    }

    public void CreateVaccinationDetails(VaccinationDetails vaccinationDetails){
        this.vaccinationDetailsRepository.save(vaccinationDetails);
    }
    public void UpdateVaccinationDetails(VaccinationDetails vaccinationDetails){
        this.vaccinationDetailsRepository.save(vaccinationDetails);
    }
    public void DeleteVaccinationDetails(VaccinationDetails vaccinationDetails){
        this.vaccinationDetailsRepository.delete(vaccinationDetails);
    }

}