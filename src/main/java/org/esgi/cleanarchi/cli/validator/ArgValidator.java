package org.esgi.cleanarchi.cli.validator;

public interface ArgValidator<T> {
    boolean validate(T args);
}
