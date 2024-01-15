package com.pacto.jobApplication.dto.response;

import lombok.Builder;

import java.util.Date;

@Builder
public class JobApplicationResponse {
    private Date appliedOn;
}
