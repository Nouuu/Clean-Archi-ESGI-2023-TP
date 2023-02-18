package org.esgi.cleanarchi.cli.dto.parser;

import org.esgi.cleanarchi.cli.dto.RemoveDto;

import java.util.List;

public class RemoveDtoParser {
    public RemoveDto parse(List<String> args){
        if (args.size() == 0) {
            return new RemoveDto(null);
        } else {
            try {
                int idToRemove = Integer.parseInt(args.get(0));
                return new RemoveDto(idToRemove);
            } catch(IllegalArgumentException exception) {
                return new RemoveDto(null);
            }
        }
    }
}
