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
}
