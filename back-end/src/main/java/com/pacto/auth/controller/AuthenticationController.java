package com.pacto.auth.controller;

import com.pacto.auth.dto.request.SignUpCandidateRequest;
import com.pacto.auth.dto.request.SignUpEmployerRequest;
import com.pacto.auth.dto.request.SigninRequest;
import com.pacto.auth.dto.response.JwtAuthenticationResponse;
import com.pacto.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signupAsEmployer")
    public JwtAuthenticationResponse signupAsEmployer(@Valid @RequestBody SignUpEmployerRequest request) {
        return authenticationService.signupAsEmployer(request);
    }

    @PostMapping("/signupAsCandidate")
    public JwtAuthenticationResponse signupAsCandidate(@Valid @RequestBody SignUpCandidateRequest request) {
        return authenticationService.signupAsCandidate(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@Valid @RequestBody SigninRequest request) {
        return authenticationService.signin(request);
    }

}
