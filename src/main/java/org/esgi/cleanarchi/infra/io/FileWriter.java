package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.kernel.Logger;
import org.esgi.cleanarchi.infra.io.exception.InputOutputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileWriter implements Writer {
    private final Path path;
    private final Logger logger;

    public FileWriter(String path, Logger logger) {
        this.path = Objects.requireNonNull(Path.of(path));
        this.logger = logger;
    }

    @Override
    public void write(String s) {
        try {
            Files.writeString(path, s);
        } catch (IOException e) {
            logger.logError("Error while writing file " + path);
            throw new InputOutputException(e.getMessage());
        }
    }
}
