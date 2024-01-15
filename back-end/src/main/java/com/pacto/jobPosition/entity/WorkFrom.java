package com.pacto.jobPosition.entity;

public enum WorkFrom {
    HOME(1),
    ON_SITE(2),
    HYBRID(3);

    private final Integer value;

    WorkFrom(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
