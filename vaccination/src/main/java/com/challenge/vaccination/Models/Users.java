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

    protected Users() {

    }

    public Users(Long userid, String username, String password, String role, Employees employee) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.employee = employee;
    }
}
