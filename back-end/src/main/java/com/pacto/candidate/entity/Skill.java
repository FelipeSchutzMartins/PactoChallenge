package com.pacto.candidate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50, message = "Descrição da hábilidade não pode ser maior do que 50 characteres")
    private String skill;
    @Size(max = 10, message = "Anos de experiência não pode ser maior do que 10 characteres")
    private String yearsUsing;

    @ManyToOne
    private Candidate candidate;

}
