package com.pacto.jobApplication.entity;

import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.candidate.entity.Candidate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "job_application")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private JobPosition position;

    private Date appliedOn;

    private String reasonClosure;

}
