package com.pacto.feedback.entity;

import com.pacto.employer.entity.Employer;
import com.pacto.jobApplication.entity.JobApplication;
import com.pacto.candidate.entity.Candidate;
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
@Table(name = "application_feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_application")
    private JobApplication application;

    private Date sendOn;

    @Size(max = 200, message = "Mensagem não pode ser maior do que 200 characteres")
    private String message;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Employer employer;

}
