package org.esgi.cleanarchi.domain;

public enum TaskState {
    TODO(0),
    PENDING(1),
    PROGRESS(2),
    DONE(3),
    CANCELLED(4),
    CLOSED(5);

    private final int value;

    TaskState(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static TaskState fromValue(int value) {
        for (TaskState status : TaskState.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TaskState value: " + value);
    }
    }
