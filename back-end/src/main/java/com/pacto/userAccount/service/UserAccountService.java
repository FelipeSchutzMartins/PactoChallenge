package com.pacto.userAccount.service;

import com.pacto.authority.entity.Authority;
import com.pacto.exceptions.UsernameAlreadyExistsException;
import com.pacto.userAccount.entity.UserAccount;
import com.pacto.userAccount.mappers.UserAccountMapper;
import com.pacto.userAccount.repository.UserAccountRepository;
import com.pacto.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccount createNew(String username, String password, List<Authority> roles) {
        if (userAccountRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException();
        }
        return UserAccountMapper.userAccount(username, PasswordUtils.encodePassword(password), roles);
    }

    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
    }
}
