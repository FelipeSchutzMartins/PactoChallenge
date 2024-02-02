package com.pacto.jobPosition.repository;

import com.pacto.candidate.entity.Candidate;
import com.pacto.employer.entity.Employer;
import com.pacto.jobPosition.entity.JobPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {

    Page<JobPosition> findAllByEmployer(Pageable pageable, Employer employer);

    @Query("SELECT position FROM JobPosition position LEFT JOIN JobApplication jp ON jp.position = position AND jp.candidate = :candidate WHERE jp.id IS NULL")
    Page<JobPosition> findAllAvailable(Candidate candidate, Pageable pageable);

}
