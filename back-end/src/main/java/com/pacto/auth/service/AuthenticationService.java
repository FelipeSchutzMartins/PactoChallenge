package com.pacto.auth.service;

import com.pacto.auth.mapper.AuthenticationMapper;
import com.pacto.auth.dto.request.SignUpRequest;
import com.pacto.auth.dto.request.SigninRequest;
import com.pacto.auth.dto.response.JwtAuthenticationResponse;
import com.pacto.employer.service.EmployerService;
import com.pacto.jobSeeker.service.JobSeekersService;
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
    private final JobSeekersService jobSeekersService;
    private final EmployerService employerService;

    public JwtAuthenticationResponse signup(UserDetailsImpl userDetails) {
        var jwt = jwtService.generateToken(userDetails);
        return AuthenticationMapper.buildJwtAuthenticationResponse(jwt);
    }
    
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userAccountService.findByUsername(request.getEmail());
        var jwt = jwtService.generateToken(UserDetailsMapper.buildUserDetailsImpl(user));
        return AuthenticationMapper.buildJwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signupAsEmployer(SignUpRequest request) {
        var employer = employerService.createNew(request.getEmail(), request.getPassword());
        return signup(UserDetailsMapper.buildUserDetailsImpl(employer.getUserAccount()));
    }

    public JwtAuthenticationResponse signupAsJobSeeker(SignUpRequest request) {
        var jobSeeker = jobSeekersService.createNew(request.getEmail(), request.getPassword());
        return signup(UserDetailsMapper.buildUserDetailsImpl(jobSeeker.getUserAccount()));
    }
}
