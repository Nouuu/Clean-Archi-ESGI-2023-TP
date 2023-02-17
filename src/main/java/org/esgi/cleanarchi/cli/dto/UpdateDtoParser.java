package org.esgi.cleanarchi.cli.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UpdateDtoParser {
    public UpdateDto parse(List<String> args){
        if (args.size() == 0) {
            return new UpdateDto(null, null, null, null);
        } else {
            try {
                int idToRemove = Integer.parseInt(args.get(0));
                return new UpdateDto(idToRemove, parseContent(args), parseDueDate(args), parseTaskState(args));
            } catch(IllegalArgumentException exception) {
                return new UpdateDto(null, parseContent(args), parseDueDate(args), parseTaskState(args));
            }
        }
    }

    private String parseContent(List<String> args) {
        int index = args.indexOf("-c");
        if (index + 1 < args.size()) {
            return args.get(index + 1);
        } else {
            return null;
        }
    }

    private ZonedDateTime parseDueDate(List<String> args) {
        String element = args.stream().filter(arg -> arg.startsWith("-d:")).findFirst().orElse(null);
        if(element == null) {
            return null;
        }
        String[] dueDateSplit = element.split(":");
        if(dueDateSplit.length == 2) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return ZonedDateTime.parse(dueDateSplit[1], formatter);
        } else {
            return null;
        }
    }

    private StateDto parseTaskState(List<String> args) {
        String element = args.stream().filter(arg -> arg.startsWith("-s:")).findFirst().orElse(null);
        if(element == null) {
            return null;
        }
        String[] dueDateSplit = element.split(":");
        if(dueDateSplit.length == 2) {
            try {
                return StateDto.fromValue(dueDateSplit[1]);
            } catch (IllegalArgumentException exception) {
                return null;
            }
        } else {
            return null;
        }
    }
}
