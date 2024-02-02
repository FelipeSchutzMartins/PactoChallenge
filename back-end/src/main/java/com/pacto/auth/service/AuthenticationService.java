package com.pacto.auth.service;

import com.pacto.auth.dto.request.SignUpCandidateRequest;
import com.pacto.auth.dto.request.SignUpEmployerRequest;
import com.pacto.auth.dto.request.SigninRequest;
import com.pacto.auth.dto.response.JwtAuthenticationResponse;
import com.pacto.auth.mapper.AuthenticationMapper;
import com.pacto.authority.entity.Authority;
import com.pacto.candidate.service.CandidateService;
import com.pacto.employer.service.EmployerService;
import com.pacto.token.service.TokenService;
import com.pacto.userAccount.service.UserAccountService;
import com.pacto.userDetails.UserDetailsMapper;
import com.pacto.userDetails.entity.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserAccountService userAccountService;
    private final TokenService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CandidateService candidateService;
    private final EmployerService employerService;

    public JwtAuthenticationResponse signup(UserDetailsImpl userDetails) {
        var jwt = jwtService.generateToken(userDetails);
        var roles = userDetails.getAuthorities().stream()
                .map(Authority::getAuthority)
                .toList();
        return AuthenticationMapper.buildJwtAuthenticationResponse(jwt, roles);
    }
    
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userAccountService.findByUsername(request.getEmail());
        var jwt = jwtService.generateToken(UserDetailsMapper.buildUserDetailsImpl(user));
        var roles = user.getAuthorities().stream()
                .map(Authority::getAuthority)
                .toList();
        return AuthenticationMapper.buildJwtAuthenticationResponse(jwt, roles);
    }

    public JwtAuthenticationResponse signupAsEmployer(SignUpEmployerRequest request) {
        var employer = employerService.createNew(request);
        return signup(UserDetailsMapper.buildUserDetailsImpl(employer.getUserAccount()));
    }

    public JwtAuthenticationResponse signupAsCandidate(SignUpCandidateRequest request) {
        var candidate = candidateService.createNew(request);
        return signup(UserDetailsMapper.buildUserDetailsImpl(candidate.getUserAccount()));
    }
}
