package com.pacto.jobSeeker.repository;

import com.pacto.jobSeeker.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

    @Query("SELECT s FROM JobSeeker s WHERE s.userAccount.username = :username")
    Optional<JobSeeker> findByUsername(String username);
}
