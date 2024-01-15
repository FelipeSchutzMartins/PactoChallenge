package com.pacto.employer.repository;

import com.pacto.employer.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    @Query("SELECT e FROM Employer e WHERE e.userAccount.username = :username")
    Optional<Employer> findByUsername(String username);

}
