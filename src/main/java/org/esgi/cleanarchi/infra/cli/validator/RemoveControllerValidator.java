package org.esgi.cleanarchi.infra.cli.validator;

import org.esgi.cleanarchi.infra.cli.dto.RemoveDto;

public class RemoveControllerValidator implements ArgValidator<RemoveDto> {
    @Override
    public boolean validate(RemoveDto removeDto) {
        return removeDto.id() != null;
    }
}
