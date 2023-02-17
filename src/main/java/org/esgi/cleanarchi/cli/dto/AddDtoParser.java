package org.esgi.cleanarchi.cli.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class AddDtoParser {
    public AddDto parse(List<String> args){
        String content = parseContent(args);
        ZonedDateTime date = parseDueDate(args);
        return new AddDto(content, date);
    }

    private String parseContent(List<String> args) {
        if (args.contains("-c") && args.indexOf("-c") +1 <= args.size()) {
            return args.get(args.indexOf("-c") + 1);
        } else {
            return null;
        }
    }

    private ZonedDateTime parseDueDate(List<String> args) {
        Optional<String> dateStr = args.stream().filter(s -> s.startsWith("-d:")).findFirst();
        if (dateStr.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr.get().split(":")[1], formatter).atStartOfDay(ZoneId.systemDefault());
    }
}
