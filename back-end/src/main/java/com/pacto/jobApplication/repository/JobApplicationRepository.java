package com.pacto.jobApplication.repository;

import com.pacto.jobApplication.entity.JobApplication;
import com.pacto.jobPosition.entity.JobPosition;
import com.pacto.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

    Optional<JobApplication> findByCandidateAndAndPosition(Candidate candidate, JobPosition position);

}
