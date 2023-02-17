package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader implements Reader {
    private final Path path;
    private final Logger logger;

    public FileReader(Path path, Logger logger) {
        this.path = path;
        this.logger = logger;
    }

    @Override
    public String read() {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            logger.logError("Error while reading file " + path);
            throw new InputOutputException(e.getMessage());
        }
    }
}
