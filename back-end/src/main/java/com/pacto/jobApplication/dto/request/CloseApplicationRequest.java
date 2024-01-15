package com.pacto.jobApplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CloseApplicationRequest {
    private Integer id;
    private String reason;
}
