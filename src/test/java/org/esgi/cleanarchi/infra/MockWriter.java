package org.esgi.cleanarchi.infra;

import org.esgi.cleanarchi.infra.io.Writer;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

public class MockWriter implements Writer {
    @Override
    public void write(String s) throws InputOutputException {
        // Do nothing
        return;
    }
}
