package com.challenge.vaccination.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

    @Id
    private Long userid;
    private String username;
    private String password;
    private String role;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
