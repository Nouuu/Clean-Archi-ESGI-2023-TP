package org.esgi.cleanarchi.infra.io;

import org.esgi.cleanarchi.infra.io.exception.InputOutputException;
import org.esgi.cleanarchi.kernel.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class FileWriter implements Writer {
    private final Path path;
    private final Logger logger;

    private final boolean append;

    private static final String NEW_LINE = System.getProperty("line.separator");

    public FileWriter(String path, Logger logger) {
        this.path = Objects.requireNonNull(Path.of(path));
        this.logger = logger;
        this.append = false;
    }

    public FileWriter(String path, Logger logger, boolean append) {
        this.path = Objects.requireNonNull(Path.of(path));
        this.logger = logger;
        this.append = append;
    }

    @Override
    public void write(String s) {
        try {
            if (append) {
                Files.writeString(path, s + NEW_LINE, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } else {
                Files.writeString(path, s, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            logger.logError("Error while writing file " + path);
            throw new InputOutputException(e.getMessage());
        }
    }
}
