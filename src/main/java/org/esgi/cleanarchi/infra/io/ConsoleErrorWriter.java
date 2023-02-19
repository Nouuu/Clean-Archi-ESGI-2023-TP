package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

public class ConsoleErrorWriter implements Writer {

    @Override
    public void write(String s) throws InputOutputException {
        System.err.println(s);
    }
}
