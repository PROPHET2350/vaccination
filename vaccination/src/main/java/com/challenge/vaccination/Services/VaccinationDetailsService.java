package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.VaccinationDetails;
import com.challenge.vaccination.Repositories.VaccinationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VaccinationDetailsService {

    @Autowired
    private VaccinationDetailsRepository vaccinationDetailsRepository;

    public VaccinationDetailsService(VaccinationDetailsRepository vaccinationDetailsRepository) {
        this.vaccinationDetailsRepository = vaccinationDetailsRepository;
    }

    public VaccinationDetails CreateVaccinationDetails(VaccinationDetails vaccinationDetails){
        return this.vaccinationDetailsRepository.save(vaccinationDetails);
    }
    public List<VaccinationDetails> filterByType(String type){
        return this.vaccinationDetailsRepository.findByType(type);
    }
    public List<VaccinationDetails> filterByDate(Date first, Date end){
        return this.vaccinationDetailsRepository.findByVaccinationDateBetween(first, end);
    }
    public VaccinationDetails findByEmployeeDetailsId(String id){
        return this.vaccinationDetailsRepository.findByEmployeesDetailsEmployeesdetailsid(id);
    }
    public List<VaccinationDetails> searchAllDetails(){
        return this.vaccinationDetailsRepository.findAll();
    }
}
