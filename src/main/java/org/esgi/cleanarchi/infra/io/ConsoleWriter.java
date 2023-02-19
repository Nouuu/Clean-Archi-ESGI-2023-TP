package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

public class ConsoleWriter implements Writer{

    @Override
    public void write(String s) throws InputOutputException {
        System.out.println(s);
    }
}
