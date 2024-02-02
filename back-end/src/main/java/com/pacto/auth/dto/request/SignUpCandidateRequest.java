package com.pacto.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpCandidateRequest {
    @NotNull(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar vázio")
    private String email;
    @NotNull(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar vázio")
    private String password;
    @NotNull(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar vázio")
    private String name;
    @NotNull(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar vázio")
    private String surname;
}
