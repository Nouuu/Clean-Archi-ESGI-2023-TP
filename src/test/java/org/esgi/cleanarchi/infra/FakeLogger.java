package org.esgi.cleanarchi.infra;

import org.esgi.cleanarchi.kernel.Logger;

public class FakeLogger implements Logger {
    @Override
    public void log(String s) {
        return;
    }

    @Override
    public void logError(String s) {
        return;
    }
}
