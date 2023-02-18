package org.esgi.cleanarchi.cli.dto.adapter;

import org.esgi.cleanarchi.cli.dto.StateDto;
import org.esgi.cleanarchi.domain.TaskState;

public class StateDtoAdapter {

    public static TaskState fromStateDtoToTaskState(StateDto stateDto) {
        return switch (stateDto) {
            case TODO -> TaskState.TODO;
            case PENDING -> TaskState.PENDING;
            case PROGRESS -> TaskState.PROGRESS;
            case DONE -> TaskState.DONE;
            case CANCELLED -> TaskState.CANCELLED;
            case CLOSED -> TaskState.CLOSED;
        };
    }
}
