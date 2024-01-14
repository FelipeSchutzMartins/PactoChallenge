package com.pacto.authority.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAuthorityRequest {
    @NotNull(message = "Invalid role")
    @NotBlank(message = "Invalid role")
    private String role;
    @NotNull
    private Integer id;
}
