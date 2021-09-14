package com.challenge.vaccination.Models;


import javax.persistence.*;

@Entity
public class Employees {
    @Id
    private Long employeeid;
    private String dni;
    private String name;
    private String lastname;
    private String mail;
    private boolean status;
    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    @JoinColumn(name = "userid")
    private Users user;
    @OneToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    @JoinColumn(name = "employeesdetailsid")
    private EmployeesDetails details;
}
