package com.pacto.employer.entity;

import com.pacto.userAccount.entity.UserAccount;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_account", referencedColumnName = "id")
    private UserAccount userAccount;

    @Size(max = 200, message = "Nome da empresa não pode ser maior do que 20 characteres")
    private String companyName;

}
