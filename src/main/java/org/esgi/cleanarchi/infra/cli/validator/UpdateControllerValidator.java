package org.esgi.cleanarchi.infra.cli.validator;

import org.esgi.cleanarchi.infra.cli.dto.UpdateDto;

public class UpdateControllerValidator implements ArgValidator<UpdateDto> {
    @Override
    public boolean validate(UpdateDto updateDto) {
        return updateDto.id() != null;
    }


}
