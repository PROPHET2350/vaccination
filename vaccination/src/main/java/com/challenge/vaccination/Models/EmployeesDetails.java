package com.challenge.vaccination.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class EmployeesDetails {
    @Id
    private Long id;
    private Date birthday;
    private String direction;
    private String phone;
    private boolean state;
}
