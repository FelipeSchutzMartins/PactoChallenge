package com.pacto.authority.entity;

public enum BaseRoles {
    ROLE_CANDIDATE("ROLE_CANDIDATE"),
    ROLE_EMPLOYER("ROLE_EMPLOYER");

    private String value;

    BaseRoles(String role) {
        this.value = role;
    }

    public String getValue() {
        return this.value;
    }
}
