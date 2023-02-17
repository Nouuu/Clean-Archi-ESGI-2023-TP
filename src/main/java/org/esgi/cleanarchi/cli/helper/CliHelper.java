package org.esgi.cleanarchi.cli.helper;

public class CliHelper {

    public CliHelper() {}

    public void printHelpMessage() {
        System.out.println("Usage: todo [command] [options]");
        System.out.println("Commands:");
        System.out.println("  add -c [content] -d [dueDate] - Add a new todo");
        System.out.println("  list - List all todos");
        System.out.println("  update [id] -c [content] -d [dueDate] -s [StateDto] - Update a todo");
        System.out.println("  remove [id] - Remove a todo");
        System.out.println("  help - Display this help message");
    }
}
