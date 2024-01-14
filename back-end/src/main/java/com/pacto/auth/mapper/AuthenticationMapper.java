package com.pacto.auth.mapper;

import com.pacto.auth.dto.response.JwtAuthenticationResponse;

public class AuthenticationMapper {

    public static JwtAuthenticationResponse buildJwtAuthenticationResponse(String token) {
        return JwtAuthenticationResponse.builder().token(token).build();
    }

}
