package com.pacto.jobSeeker.entity;

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
@Table(name = "job_seeker")
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_account", referencedColumnName = "id")
    private UserAccount userAccount;

    @Size(max = 200, message = "Campo \"Sobre você\" não pode ser maior do que 200 characteres")
    private String about;

    @Size(max = 13, message = "Campo telefone não pode ser maior do que 13 characteres")
    private String phone;

    @OneToOne
    private Education education;

    @OneToMany
    private List<Skill> sklls;

    @OneToMany
    private List<Experience> experiences;

}
