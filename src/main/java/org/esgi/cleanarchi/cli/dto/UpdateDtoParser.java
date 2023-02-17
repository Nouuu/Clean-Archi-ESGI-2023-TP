package org.esgi.cleanarchi.cli.dto;

import java.util.Arrays;

public class UpdateDtoParser {
    public UpdateDtoParser parse(String[] args){
        if (args.length == 0) {
            return new UpdateDto(null);
        } else {
            try {
                int idToRemove = Integer.parseInt(args[0]);
                return new UpdateDto(idToRemove);
            } catch(IllegalArgumentException exception) {
                return new UpdateDto(null);
            }
        }
    }

    private String parseContent(String[] args) {
        int index = Arrays.stream(args).toList().indexOf(  )
    }
}
