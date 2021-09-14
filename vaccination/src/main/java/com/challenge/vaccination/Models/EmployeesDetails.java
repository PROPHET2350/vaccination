package com.challenge.vaccination.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeesDetails {
    @Id
    private Long employeesdetailsid;
    private Date birthday;
    private String direction;
    private String phone;
    private boolean state;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Employees employee;
    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employeesDetails")
    @JoinColumn(name = "vaccinationdetailsid")
    private VaccinationDetails vaccinationDetails;
}
