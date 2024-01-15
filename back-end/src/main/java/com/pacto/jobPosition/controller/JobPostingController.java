package com.pacto.jobPosition.controller;

import com.pacto.jobPosition.dto.request.JobPositionRequest;
import com.pacto.jobPosition.dto.request.JobPositionUpdate;
import com.pacto.jobPosition.dto.response.JobPositionResponse;
import com.pacto.jobPosition.service.JobPositionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobPosting")
@RequiredArgsConstructor
public class JobPostingController {

    private final JobPositionService jobPositionService;

    @Secured("ROLE_EMPLOYER")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public JobPositionResponse create(
            @Valid @RequestBody JobPositionRequest request,
            @RequestHeader("authorization") String authToken
    ) {
        return jobPositionService.create(request, authToken);
    }

    @Secured("ROLE_EMPLOYER")
    @PutMapping("/update")
    public JobPositionResponse update(@Valid @RequestBody JobPositionUpdate request) throws Exception {
        return jobPositionService.update(request);
    }

    @Secured("ROLE_EMPLOYER")
    @PutMapping("/close/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        jobPositionService.close(id);
    }

}
