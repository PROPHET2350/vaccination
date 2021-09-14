package com.challenge.vaccination.Models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employees {
    @Id
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private String mail;
    private boolean status;
}
