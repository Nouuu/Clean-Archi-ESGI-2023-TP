package org.esgi.cleanarchi.infra.cli.validator;

import org.esgi.cleanarchi.infra.cli.dto.AddDto;

public class AddControllerValidator implements ArgValidator<AddDto> {
    @Override
    public boolean validate(AddDto dto) {
        return dto.content() != null;
    }
}
