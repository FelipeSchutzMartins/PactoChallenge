package com.pacto.jobApplication.service;

import com.pacto.jobApplication.dto.request.ApplyRequest;
import com.pacto.jobApplication.dto.request.CloseApplicationRequest;
import com.pacto.jobApplication.dto.response.JobApplicationResponse;
import com.pacto.jobApplication.entity.JobApplication;
import com.pacto.jobApplication.mapper.JobApplicationMapper;
import com.pacto.jobApplication.repository.JobApplicationRepository;
import com.pacto.jobPosition.service.JobPositionService;
import com.pacto.candidate.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final CandidateService candidateService;
    private final JobPositionService jobPositionService;

    public JobApplicationResponse closeApplication(CloseApplicationRequest request) throws Exception {
        var jobApplication = findById(request.getId());
        jobApplication.setReasonClosure(request.getReason());
        jobApplicationRepository.save(jobApplication);
        return JobApplicationMapper.buildJobApplicationResponse(jobApplication);
    }

    public JobApplicationResponse apply(ApplyRequest request, String authToken) throws Exception {
        var candidate = candidateService.getCandidateFromToken(authToken);
        var position = jobPositionService.findById(request.getPositionId());
        if (jobApplicationRepository.findByCandidateAndAndPosition(candidate, position).isPresent())  {
            throw new Exception("Can't apply for the same position twice");
        }
        var jobApplication = JobApplicationMapper.buildNewApplication(new Date(), candidate, position);
        jobApplicationRepository.save(jobApplication);
        return JobApplicationMapper.buildJobApplicationResponse(jobApplication);
    }

    public JobApplication findById(Integer id) throws Exception {
        return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new Exception("Application not found"));
    }
}
