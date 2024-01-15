package com.pacto.jobPosition.mapper;

import com.pacto.employer.entity.Employer;
import com.pacto.jobPosition.dto.response.JobPositionResponse;
import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.jobPosition.entity.WorkFrom;

import java.util.Date;

public class JobPositionMapper {

    public static JobPosition buildNewJobPosition(
            Employer employer,
            String positionTitle,
            String aboutJob,
            Date postedOn,
            WorkFrom workFrom
    ) {
        return JobPosition.builder()
                .employer(employer)
                .positionTitle(positionTitle)
                .aboutJob(aboutJob)
                .postedOn(postedOn)
                .workFrom(workFrom)
                .build();
    }

    public static JobPositionResponse buildJobPositionResponse(JobPosition jobPosition) {
        return JobPositionResponse.builder()
                .id(jobPosition.getId())
                .aboutJob(jobPosition.getAboutJob())
                .positionTitle(jobPosition.getPositionTitle())
                .workFrom(jobPosition.getWorkFrom())
                .postedOn(jobPosition.getPostedOn())
                .closedOn(jobPosition.getClosedOn())
                .build();
    }

}
