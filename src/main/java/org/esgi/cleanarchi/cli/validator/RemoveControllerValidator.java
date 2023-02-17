package org.esgi.cleanarchi.cli.validator;

import org.esgi.cleanarchi.cli.dto.RemoveDto;

public class RemoveControllerValidator implements ArgValidator<RemoveDto> {
    @Override
    public boolean validate(RemoveDto removeDto) {
        return removeDto.id() != null;
    }
}
