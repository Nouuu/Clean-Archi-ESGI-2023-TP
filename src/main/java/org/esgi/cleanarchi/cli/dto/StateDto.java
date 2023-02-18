package org.esgi.cleanarchi.cli.dto;

import org.esgi.cleanarchi.domain.TaskState;

import java.util.Objects;

public enum StateDto {
    TODO("todo"),
    PENDING("pending"),
    PROGRESS("progress"),
    DONE("done"),
    CANCELLED("cancelled"),
    CLOSED("closed");

    private final String value;

    StateDto(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static StateDto fromValue(String value) {
        for (StateDto status : StateDto.values()) {
            if (Objects.equals(status.value, value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TaskState value: " + value);
    }
}
