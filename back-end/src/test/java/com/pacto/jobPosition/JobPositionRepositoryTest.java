package com.pacto.jobPosition;

import com.pacto.jobPosition.repository.JobPositionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class JobPositionRepositoryTest {


    @Autowired
    private JobPositionRepository repository;

    @Test
    void shouldSaveJobPosition() {
        this.repository.save(JobPositionStubs.createPositionStub());
        assertEquals(1, this.repository.findAll().size());
    }

}
