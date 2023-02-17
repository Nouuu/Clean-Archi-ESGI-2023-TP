package org.esgi.cleanarchi.cli.dto;

public class RemoveDtoParser {
    public RemoveDto parse(String[] args){
        if (args.length == 0) {
            return new RemoveDto(null);
        } else {
            try {
                int idToRemove = Integer.parseInt(args[0]);
                return new RemoveDto(idToRemove);
            } catch(IllegalArgumentException exception) {
                return new RemoveDto(null);
            }
        }
    }
}
