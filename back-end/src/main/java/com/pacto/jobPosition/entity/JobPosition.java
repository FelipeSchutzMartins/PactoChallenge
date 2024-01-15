package com.pacto.jobPosition.entity;

import com.pacto.employer.entity.Employer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_position")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Employer employer;

    @Size(max = 50, message = "Limite máximo de caracteres (50) atingido")
    private String positionTitle;

    @Size(max = 50, message = "Limite máximo de caracteres (500) atingido")
    private String aboutJob;

    private Date postedOn;

    @Enumerated
    private WorkFrom workFrom;

    private Date closedOn;

}
