package com.pacto.employer.service;

import com.pacto.authority.entity.BaseRoles;
import com.pacto.authority.service.AuthorityService;
import com.pacto.employer.entity.Employer;
import com.pacto.employer.repository.EmployerRepository;
import com.pacto.userAccount.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final UserAccountService userAccountService;
    private final AuthorityService authorityService;

    public Employer createNew(String email, String password) {
        var employer = new Employer();
        var authority = authorityService.findByRole(BaseRoles.ROLE_EMPLOYER.getValue());
        employer.setUserAccount(userAccountService.createNew(email, password, List.of(authority)));
        employer.setCompanyName("");
        return employerRepository.save(employer);
    }
}
