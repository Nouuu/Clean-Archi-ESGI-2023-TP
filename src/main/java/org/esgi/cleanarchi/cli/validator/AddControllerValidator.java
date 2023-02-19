package org.esgi.cleanarchi.cli.validator;

import org.esgi.cleanarchi.cli.dto.AddDto;

public class AddControllerValidator implements ArgValidator<AddDto> {
    @Override
    public boolean validate(AddDto dto) {
        return dto.content() != null;
    }
}
