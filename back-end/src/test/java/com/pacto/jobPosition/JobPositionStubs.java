package com.pacto.jobPosition;

import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.jobPosition.entity.WorkFrom;

import java.util.Date;

public class JobPositionStubs {
    public static JobPosition createPositionStub() {
        return JobPosition.builder()
                .positionTitle("Java Developer")
                .aboutJob("")
                .postedOn(new Date())
                .workFrom(WorkFrom.HOME)
                .build();
    }
}
