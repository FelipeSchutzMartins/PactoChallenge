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
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date startDate;
    private Date endDate;

    @Size(max = 50, message = "Instituição não pode ser maior do que 50 characteres")
    private String institution;
    @Size(max = 50, message = "Nome do curso não pode ser maior do que 50 characteres")
    private String courseName;

    @Column(name = "kind_degree")

    @Size(max = 50, message = "Tipo de curso não pode ser maior do que 50 characteres")
    private String degree;

    @OneToOne
    private JobSeeker jobSeeker;
}
