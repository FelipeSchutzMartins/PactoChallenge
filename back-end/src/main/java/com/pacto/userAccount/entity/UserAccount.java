package com.pacto.userAccount.entity;

import com.pacto.authority.entity.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "authority_user_account",
            joinColumns = @JoinColumn(name = "id_user_account"),
            inverseJoinColumns = @JoinColumn(name = "id_authority"))
    private List<Authority> authorities;

}
