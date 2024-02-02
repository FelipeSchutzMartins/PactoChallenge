package com.pacto.employer.service;

import com.pacto.auth.dto.request.SignUpEmployerRequest;
import com.pacto.authority.entity.BaseRoles;
import com.pacto.authority.service.AuthorityService;
import com.pacto.employer.entity.Employer;
import com.pacto.employer.repository.EmployerRepository;
import com.pacto.token.service.TokenService;
import com.pacto.userAccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.security.config.Elements.JWT;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final UserAccountService userAccountService;
    private final AuthorityService authorityService;
    private final TokenService jwtService;

    public Employer createNew(SignUpEmployerRequest request) {
        var employer = new Employer();
        var authority = authorityService.findByRole(BaseRoles.ROLE_EMPLOYER.getValue());
        employer.setUserAccount(userAccountService.createNew(
                request.getEmail(), request.getPassword(), List.of(authority)));
        employer.setCompanyName(request.getCompanyName());
        return employerRepository.save(employer);
    }

    public Employer findByUsername(String username) {
        return employerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public Employer getEmployerFromToken(String authToken) {
        return findByUsername(jwtService.extractUserName(authToken));
    }

}
