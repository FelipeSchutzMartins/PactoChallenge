package com.pacto.userDetails;

import com.pacto.userAccount.entity.UserAccount;
import com.pacto.userDetails.entity.UserDetailsImpl;

public class UserDetailsMapper {

    public static UserDetailsImpl buildUserDetailsImpl(UserAccount userAccount) {
        return UserDetailsImpl.builder()
                .userAccount(userAccount)
                .build();
    }

}
