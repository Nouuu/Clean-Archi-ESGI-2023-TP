package org.esgi.cleanarchi.cli.validator;

import java.util.Arrays;

public class AddControllerValidator implements ArgValidator {

    @Override
    public boolean validate(String[] args) {
        return !Arrays.asList(args).contains("-s") && args.length >= Arrays.asList(args).indexOf("-c") + 1;
    }
}
