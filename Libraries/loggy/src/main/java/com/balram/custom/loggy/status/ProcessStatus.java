package com.balram.custom.loggy.status;

import lombok.Getter;

public enum ProcessStatus {
    START("Start"),
    INTERMEDIATE("Intermediate"),
    END("End");

    @Getter
    private final String status;

    ProcessStatus(String status) {
        this.status = status;
    }
}

