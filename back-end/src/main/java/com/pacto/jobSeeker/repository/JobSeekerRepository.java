package com.pacto.jobSeeker.repository;

import com.pacto.jobSeeker.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {}
