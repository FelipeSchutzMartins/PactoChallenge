package com.pacto.candidate.repository;

import com.pacto.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query("SELECT s FROM Candidate s WHERE s.userAccount.username = :username")
    Optional<Candidate> findByUsername(String username);
}
