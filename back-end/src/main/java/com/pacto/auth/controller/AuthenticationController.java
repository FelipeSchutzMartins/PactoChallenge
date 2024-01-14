package com.pacto.auth.controller;

import com.pacto.auth.dto.request.SigninRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pacto.auth.service.AuthenticationService;
import com.pacto.auth.dto.request.SignUpRequest;
import com.pacto.auth.dto.response.JwtAuthenticationResponse;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signupAsEmployer")
    public JwtAuthenticationResponse signupAsEmployer(@Valid @RequestBody SignUpRequest request) {
        return authenticationService.signupAsEmployer(request);
    }

    @PostMapping("/signupAsJobSeeker")
    public JwtAuthenticationResponse signupAsJobSeeker(@Valid @RequestBody SignUpRequest request) {
        return authenticationService.signupAsJobSeeker(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@Valid @RequestBody SigninRequest request) {
        return authenticationService.signin(request);
    }

}
