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

    private EmployeesDetails() {
    }

    public EmployeesDetails(Long employeesdetailsid, Date birthday, String direction, String phone, boolean state, Employees employee) {
        this.employeesdetailsid = employeesdetailsid;
        this.birthday = birthday;
        this.direction = direction;
        this.phone = phone;
        this.state = state;
        this.employee = employee;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setVaccinationDetails(VaccinationDetails vaccinationDetails) {
        this.vaccinationDetails = vaccinationDetails;
    }

    public Long getEmployeesdetailsid() {
        return employeesdetailsid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getDirection() {
        return direction;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isState() {
        return state;
    }

    public Employees getEmployee() {
        return employee;
    }

    public VaccinationDetails getVaccinationDetails() {
        return vaccinationDetails;
    }
}
