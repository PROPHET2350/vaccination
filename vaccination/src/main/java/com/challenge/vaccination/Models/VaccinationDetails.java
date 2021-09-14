package com.challenge.vaccination.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class VaccinationDetails {
    @Id
    private Long id;
    private String type;
    private Date vaccinationDate;
    private int doseNumber;
}
