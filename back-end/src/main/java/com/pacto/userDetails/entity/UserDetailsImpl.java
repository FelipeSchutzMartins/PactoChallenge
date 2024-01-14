package com.pacto.userDetails.entity;

import com.pacto.authority.entity.Authority;
import com.pacto.userAccount.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private UserAccount userAccount;

    @Override
    public List<Authority> getAuthorities() {
        return userAccount.getAuthorities();
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
