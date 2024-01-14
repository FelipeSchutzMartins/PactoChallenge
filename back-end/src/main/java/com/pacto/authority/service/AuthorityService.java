package com.pacto.authority.service;

import com.pacto.authority.AuthorityMapper;
import com.pacto.authority.entity.Authority;
import com.pacto.authority.repository.AuthorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class AuthorityService {

    private AuthorityRepository authorityRepository;

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    public Authority createAuthority(String role) {
        var authority = authorityRepository.findByRole(role);
        return authority.orElseGet(() -> authorityRepository.save(AuthorityMapper.buildAuthority(role)));
    }

    public Authority updateAuthority(String role, Integer id) {
        var authority = findById(id);
        authority.setRole(role);
        return authorityRepository.save(authority);
    }

    public void delete(Integer id) {
        authorityRepository.delete(findById(id));
    }

    public Authority findById(Integer id) {
        return authorityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Authority not found"));
    }
}
