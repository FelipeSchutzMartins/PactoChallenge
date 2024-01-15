package com.pacto.jobApplication.mapper;

import com.pacto.jobApplication.dto.response.JobApplicationResponse;
import com.pacto.jobApplication.entity.JobApplication;
import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.jobSeeker.entity.JobSeeker;

import java.util.Date;

public class JobApplicationMapper {

    public static JobApplicationResponse buildJobApplicationResponse(JobApplication jobApplication) {
        return JobApplicationResponse.builder()
                .appliedOn(jobApplication.getAppliedOn())
                .build();
    }

    public static JobApplication buildNewApplication(
            Date appliedOn,
            JobSeeker jobSeeker,
            JobPosition position
    ) {
        return JobApplication.builder()
                .appliedOn(appliedOn)
                .jobSeeker(jobSeeker)
                .position(position)
                .build();
    }

}
