package org.esgi.cleanarchi.infra.cli.dto.adapter;

import org.esgi.cleanarchi.domain.TaskState;
import org.esgi.cleanarchi.infra.cli.dto.StateDto;

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
