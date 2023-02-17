package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

public interface Reader {
    String read() throws InputOutputException;
}
