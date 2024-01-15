package com.pacto.jobPosition.service;

import com.pacto.employer.service.EmployerService;
import com.pacto.jobPosition.dto.request.JobPositionRequest;
import com.pacto.jobPosition.dto.request.JobPositionUpdate;
import com.pacto.jobPosition.dto.response.JobPositionResponse;
import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.jobPosition.mapper.JobPositionMapper;
import com.pacto.jobPosition.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JobPositionService {

    private final EmployerService employerService;
    private final JobPositionRepository jobPositionRepository;

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
}
