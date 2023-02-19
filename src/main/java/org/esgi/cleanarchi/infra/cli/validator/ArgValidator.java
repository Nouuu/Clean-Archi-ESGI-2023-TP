package org.esgi.cleanarchi.infra.cli.validator;

public interface ArgValidator<T> {
    boolean validate(T args);
}
