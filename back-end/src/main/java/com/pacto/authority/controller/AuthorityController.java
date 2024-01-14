package com.pacto.authority.controller;

import com.pacto.authority.dtos.request.CreateAuthorityRequest;
import com.pacto.authority.dtos.request.UpdateAuthorityRequest;
import com.pacto.authority.entity.Authority;
import com.pacto.authority.service.AuthorityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authority")
@Secured("ROLE_ADMIN")
public class AuthorityController {

    private AuthorityService authorityService;

    @GetMapping("/findAll")
    public List<Authority> findAll() {
        return authorityService.findAll();
    }

    @PostMapping("/create")
    public Authority createAuthority(@Valid @RequestBody CreateAuthorityRequest request) {
        return authorityService.createAuthority(request.getRole());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        authorityService.delete(id);
    }

    @PostMapping("/edit")
    public Authority edit(@Valid @RequestBody UpdateAuthorityRequest request) {
        return authorityService.updateAuthority(request.getRole(), request.getId());
    }
}
