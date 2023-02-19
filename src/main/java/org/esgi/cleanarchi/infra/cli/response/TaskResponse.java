package org.esgi.cleanarchi.infra.cli.response;


import com.google.gson.Gson;

import java.util.List;

public record TaskResponse(
        String id,
        String description,
        String createdDate,
        String closeDate,
        String TaskState,
        String dueDate,
        List<TaskResponse> subTasks
) {

    public String toJsonView() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}