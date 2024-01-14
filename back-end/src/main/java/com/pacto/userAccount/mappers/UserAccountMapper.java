package com.pacto.userAccount.mappers;

import com.pacto.authority.entity.Authority;
import com.pacto.userAccount.entity.UserAccount;
import org.apache.catalina.User;

import java.util.List;

public class UserAccountMapper {

    public static UserAccount userAccount(
            String username,
            String password,
            List<Authority> roles
    ) {
        return UserAccount.builder()
                .username(username)
                .password(password)
                .authorities(roles)
                .build();
    }

}
