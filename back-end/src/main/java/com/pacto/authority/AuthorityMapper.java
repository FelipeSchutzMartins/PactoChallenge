package com.pacto.authority;


import com.pacto.authority.entity.Authority;

public class AuthorityMapper {
    public static Authority buildAuthority(String role) {
        return Authority.builder()
                .role(role)
                .build();
    }
}
