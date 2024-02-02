package com.pacto.candidate.entity;

import com.pacto.userAccount.entity.UserAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAccount userAccount;

    @Size(max = 200, message = "Campo \"Sobre você\" não pode ser maior do que 200 characteres")
    private String about;

    @Size(max = 13, message = "Campo telefone não pode ser maior do que 13 characteres")
    private String phone;

    @Size(max = 30, message = "Campo nome não pode ser maior do que 30 characteres")
    @Column(name = "candidate_name")
    private String name;

    @Size(max = 30, message = "Campo sobrenome não pode ser maior do que 30 characteres")
    @Column(name = "candidate_surname")
    private String surname;

    @OneToOne(mappedBy = "candidate")
    private Education education;

    @OneToMany
    private List<Skill> sklls;

    @OneToMany
    private List<Experience> experiences;

}
