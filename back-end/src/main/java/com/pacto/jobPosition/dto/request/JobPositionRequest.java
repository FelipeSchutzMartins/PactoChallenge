package com.pacto.jobPosition.dto.request;

import com.pacto.jobPosition.entity.WorkFrom;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobPositionRequest {
    @NotNull(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar vázio")
    private String positionTitle;
    @NotNull(message = "Não pode ser nulo")
    @NotBlank(message = "Não pode estar vázio")
    private String aboutJob;
    @NotNull(message = "Não pode ser nulo")
    private WorkFrom workFrom;
}
