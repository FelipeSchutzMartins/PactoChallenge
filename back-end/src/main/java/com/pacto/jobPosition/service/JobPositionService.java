package com.pacto.jobPosition.service;

import com.pacto.candidate.service.CandidateService;
import com.pacto.employer.service.EmployerService;
import com.pacto.jobPosition.dto.request.JobPositionRequest;
import com.pacto.jobPosition.dto.request.JobPositionUpdate;
import com.pacto.jobPosition.dto.response.JobPositionResponse;
import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.jobPosition.mapper.JobPositionMapper;
import com.pacto.jobPosition.repository.JobPositionRepository;
import com.pacto.token.service.TokenService;
import com.pacto.userAccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPositionService {

    private final EmployerService employerService;
    private final JobPositionRepository jobPositionRepository;
    private final CandidateService candidateService;

    public JobPositionResponse create(JobPositionRequest request, String token) {
        var employer = employerService.getEmployerFromToken(token);
        var jobPosting = JobPositionMapper.buildNewJobPosition(
                employer, request.getPositionTitle(), request.getAboutJob(), new Date(), request.getWorkFrom());
        return JobPositionMapper.buildJobPositionResponse(jobPositionRepository.save(jobPosting));
    }


    public JobPositionResponse update(JobPositionUpdate request) throws Exception {
        var jobPosting = findById(request.getId());
        jobPosting.setWorkFrom(request.getWorkFrom());
        jobPosting.setPositionTitle(request.getPositionTitle());
        jobPosting.setAboutJob(request.getAboutJob());
        jobPositionRepository.save(jobPosting);
        return JobPositionMapper.buildJobPositionResponse(jobPosting);
    }

    public JobPosition findById(Integer id) throws Exception {
        return jobPositionRepository.findById(id)
                .orElseThrow(() -> new Exception("Job position not found!"));
    }

    public void close(Integer id) throws Exception {
        var jobPosition = findById(id);
        jobPosition.setClosedOn(new Date());
        jobPositionRepository.delete(jobPosition);
    }

    public Page<JobPositionResponse> list(Pageable pageable, String authToken) {
        var employer = employerService.getEmployerFromToken(authToken);
        return jobPositionRepository.findAllByEmployer(pageable, employer)
                .map(JobPositionMapper::buildJobPositionResponse);
    }

    public Page<JobPositionResponse> listAvailable(Pageable pageable, String authToken) {
        var candidate = candidateService.getCandidateFromToken(authToken);
        return jobPositionRepository.findAllAvailable(candidate, pageable)
                .map(JobPositionMapper::buildJobPositionResponse);
    }
}

