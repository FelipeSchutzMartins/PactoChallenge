package com.pacto.jobPosition.dto.response;

import com.pacto.jobPosition.entity.WorkFrom;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JobPositionResponse {
    private Integer id;
    private String positionTitle;
    private String aboutJob;
    private WorkFrom workFrom;
    private Date postedOn;
    private Date closedOn;
}
