package org.esgi.cleanarchi.infra;

import org.esgi.cleanarchi.infra.io.Reader;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

public class MockReader implements Reader {
    private String content;
    public MockReader() {
        this.content = "";
    }

    public void setNextContent(String content) {
        this.content = content;
    }

    @Override
    public String read() throws InputOutputException {
        return content;
    }
}
