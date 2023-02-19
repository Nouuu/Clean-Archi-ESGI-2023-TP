package org.esgi.cleanarchi.cli.helper;

import org.esgi.cleanarchi.infra.io.Writer;

public class CliHelper {
    private final Writer writer;
    public CliHelper(Writer writer) {
        this.writer = writer;
    }

    public void printHelpMessage() {
        this.writer.write("Usage: todo [command] [options]");
        this.writer.write("Commands:");
        this.writer.write("  add -c [content] -d [dueDate] - Add a new todo");
        this.writer.write("  list - List all todos");
        this.writer.write("  update [id] -c [content] -d [dueDate] -s [StateDto] - Update a todo");
        this.writer.write("  remove [id] - Remove a todo");
        this.writer.write("  help - Display this help message");
    }

    public void printErrorCommandNotKnown() {
        this.writer.write("Error: Command not known");
    }
}
