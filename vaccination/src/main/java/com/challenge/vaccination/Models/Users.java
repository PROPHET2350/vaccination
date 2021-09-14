package com.challenge.vaccination.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
}
