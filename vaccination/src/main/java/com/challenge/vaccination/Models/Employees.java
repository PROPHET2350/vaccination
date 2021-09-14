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
    @OneToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    @JoinColumn(name = "userid")
    private Users user;
    @OneToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    @JoinColumn(name = "employeesdetailsid")
    private EmployeesDetails details;

    protected Employees() {
    }

    public Employees(Long employeeid, String dni, String name, String lastname, String mail) {
        this.employeeid = employeeid;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.status = false;
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return mail;
    }

    public boolean isStatus() {
        return status;
    }

    public Users getUser() {
        return user;
    }

    public EmployeesDetails getDetails() {
        return details;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setDetails(EmployeesDetails details) {
        this.details = details;
    }
}
