package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

public interface Writer {
    void write(String s) throws InputOutputException;
}
