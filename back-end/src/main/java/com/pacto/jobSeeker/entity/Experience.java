package com.pacto.jobSeeker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date startDate;
    private Date endDate;

    @Size(max = 50, message = "Nome da empresa não pode ser maior do que 50 characteres")
    private String company;

    @Size(max = 300, message = "Responsabilidade não pode ser maior do que 300 characteres")
    private String responsibilities;

    @Size(max = 50, message = "Cargo não pode ser maior do que 50 characteres")
    private String workPosition;

    private Boolean currentlyWorking;

    @ManyToOne
    private JobSeeker jobSeeker;

}
