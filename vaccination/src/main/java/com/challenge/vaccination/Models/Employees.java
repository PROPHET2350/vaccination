package com.challenge.vaccination.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employees implements Serializable {
    @Id
    private Long employeeid;
    private String dni;
    private String name;
    private String lastname;
    private String mail;
    private boolean status;

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
    public void setStatus(boolean status) {
        this.status = status;
    }
}
