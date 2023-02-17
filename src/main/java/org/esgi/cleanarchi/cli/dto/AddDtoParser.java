package org.esgi.cleanarchi.cli.dto;

import java.util.Date;
import java.util.List;

public class AddDtoParser {
    public AddDto parse(List<String> args){
        String content = parseContent(args);
        Date date = parseDueDate(args);

        return new AddDto(content, date);
    }
    private String parseContent(List<String> args) {
        if(args.contains("-c") && args.indexOf("-c") + 1 >= args.size()) {
            return args.get(args.indexOf("-c") + 1);
        }else{
            return null;
        }
    }
    private Date parseDueDate(List<String> args) {
        return args.stream().filter(s -> s.startsWith("-d")).findFirst().orElseGet(null);
    }
}
