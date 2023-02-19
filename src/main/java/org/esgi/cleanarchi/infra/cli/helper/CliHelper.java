package org.esgi.cleanarchi.infra.cli.helper;

import org.esgi.cleanarchi.domain.Task;
import org.esgi.cleanarchi.infra.io.Writer;

public class CliHelper {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLUE_DARKER = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
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

    public void displayColoredTask(Task task) {
        var color = switch (task.taskState()) {
            case TODO -> ANSI_PURPLE;
            case PENDING -> ANSI_CYAN;
            case PROGRESS -> ANSI_YELLOW;
            case DONE -> ANSI_GREEN;
            case CANCELLED -> ANSI_BLUE;
            case CLOSED -> ANSI_BLUE_DARKER;
        };
        this.writer.write(color + task);
    }
    public void displayOverdueTask(Task task){
        this.writer.write(ANSI_RED + task);
    }
}
