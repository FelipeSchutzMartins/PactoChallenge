package com.pacto.jobApplication.controller;

import com.pacto.jobApplication.dto.request.ApplyRequest;
import com.pacto.jobApplication.dto.request.CloseApplicationRequest;
import com.pacto.jobApplication.dto.response.JobApplicationResponse;
import com.pacto.jobApplication.service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobApplication")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @Secured("ROLE_JOB_SEEKER")
    @PostMapping("/apply")
    public JobApplicationResponse apply(
            @Valid @RequestBody ApplyRequest request,
            @RequestHeader("authorization") String authToken
    ) throws Exception {
        return jobApplicationService.apply(request, authToken);
    }

    @Secured("ROLE_JOB_SEEKER")
    @PostMapping("/giveup")
    public JobApplicationResponse apply(
            @Valid @RequestBody CloseApplicationRequest request
    ) throws Exception {
        return jobApplicationService.closeApplication(request);
    }

}
