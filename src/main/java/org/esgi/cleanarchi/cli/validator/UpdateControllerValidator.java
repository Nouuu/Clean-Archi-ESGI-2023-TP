package org.esgi.cleanarchi.cli.validator;

import org.esgi.cleanarchi.cli.dto.UpdateDto;

public class UpdateControllerValidator implements ArgValidator<UpdateDto> {
    @Override
    public boolean validate(UpdateDto args) {

        return true;
    }

}
