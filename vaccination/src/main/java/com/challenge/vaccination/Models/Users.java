package com.challenge.vaccination.Models;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    private Long userid;
    private String username;
    private String password;
    private String role;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Employees employee;
}
