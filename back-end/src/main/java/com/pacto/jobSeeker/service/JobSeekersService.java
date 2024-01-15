package com.pacto.jobSeeker.service;

import com.pacto.authority.entity.BaseRoles;
import com.pacto.authority.service.AuthorityService;
import com.pacto.jobSeeker.entity.JobSeeker;
import com.pacto.jobSeeker.repository.JobSeekerRepository;
import com.pacto.token.service.TokenService;
import com.pacto.userAccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSeekersService {

    private final JobSeekerRepository jobSeekerRepository;
    private final UserAccountService userAccountService;
    private final AuthorityService authorityService;
    private final TokenService jwtService;

    public JobSeeker createNew(String email, String password) {
        var jobSeeker = new JobSeeker();
        var authority = authorityService.findByRole(BaseRoles.ROLE_JOB_SEEKER.getValue());
        jobSeeker.setUserAccount(userAccountService.createNew(email, password, List.of(authority)));
        jobSeeker.setAbout("");
        jobSeeker.setPhone("");
        return jobSeekerRepository.save(jobSeeker);
    }

    public JobSeeker findByUsername(String username) throws Exception {
        return jobSeekerRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("Job seeker not found"));
    }

    public JobSeeker getJobSeekerFromToken(String authToken) throws Exception {
        String token = authToken.substring("Bearer ".length());
        return findByUsername(jwtService.extractUserName(token));
    }
}
