package com.pacto.authority.service;

import com.pacto.authority.entity.Authority;
import com.pacto.authority.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public Authority findByRole(String role) {
        return authorityRepository.findByAuthority(role)
                .orElseThrow(() -> new RuntimeException("Authority not found"));
    }

}
