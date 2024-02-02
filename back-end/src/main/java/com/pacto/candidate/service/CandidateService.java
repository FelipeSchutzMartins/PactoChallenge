package com.pacto.candidate.service;

import com.pacto.auth.dto.request.SignUpCandidateRequest;
import com.pacto.authority.entity.BaseRoles;
import com.pacto.authority.service.AuthorityService;
import com.pacto.candidate.entity.Candidate;
import com.pacto.candidate.repository.CandidateRepository;
import com.pacto.token.service.TokenService;
import com.pacto.userAccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final UserAccountService userAccountService;
    private final AuthorityService authorityService;
    private final TokenService jwtService;

    public Candidate createNew(SignUpCandidateRequest request) {
        var candidate = new Candidate();
        var authority = authorityService.findByRole(BaseRoles.ROLE_CANDIDATE.getValue());
        candidate.setUserAccount(userAccountService.createNew(
                request.getEmail(), request.getPassword(), List.of(authority)));
        candidate.setName(request.getName());
        candidate.setSurname(request.getSurname());
        candidate.setAbout("");
        candidate.setPhone("");
        return candidateRepository.save(candidate);
    }

    public Candidate findByUsername(String username) {
        return candidateRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public Candidate getCandidateFromToken(String authToken) {
        return findByUsername(jwtService.extractUserName(authToken));
    }
}
