package com.pacto.auth.mapper;

import com.pacto.auth.dto.response.JwtAuthenticationResponse;

import java.util.List;

public class AuthenticationMapper {

    public static JwtAuthenticationResponse buildJwtAuthenticationResponse(String token, List<String> roles) {
        return JwtAuthenticationResponse.builder()
                .token(token)
                .roles(roles)
                .build();
    }

}
