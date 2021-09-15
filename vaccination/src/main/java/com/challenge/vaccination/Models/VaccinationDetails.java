package com.challenge.vaccination.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VaccinationDetails {
    @Id
    private Long vaccinationdetailsid;
    private String type;
    private Date vaccinationDate;
    private int doseNumber;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private EmployeesDetails employeesDetails;

    protected VaccinationDetails() {}

    public VaccinationDetails(Long vaccinationdetailsid, String type, Date vaccinationDate, int doseNumber, EmployeesDetails employeesDetails) {
        this.vaccinationdetailsid = vaccinationdetailsid;
        this.type = type;
        this.vaccinationDate = vaccinationDate;
        this.doseNumber = doseNumber;
        this.employeesDetails = employeesDetails;
    }

    public Long getVaccinationdetailsid() {
        return vaccinationdetailsid;
    }

    public String getType() {
        return type;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public EmployeesDetails getEmployeesDetails() {
        return employeesDetails;
    }
}
