package com.pacto.authority.entity;

public enum BaseRoles {
    ROLE_JOB_SEEKER("ROLE_JOB_SEEKER"),
    ROLE_EMPLOYER("ROLE_EMPLOYER")
    ;

    private String value;

    BaseRoles(String roleJobSeeker) {
        this.value = roleJobSeeker;
    }

    public String getValue() {
        return this.value;
    }
}
