package org.esgi.cleanarchi.infra.cli.helper;

import java.time.ZonedDateTime;
import java.util.function.Predicate;
import org.esgi.cleanarchi.domain.Task;

public class OverdueTaskPredicate implements Predicate<Task> {
    @Override
    public boolean test(Task task) {
        return hasBeenClosed(task) && hasDueDate(task) && dueDatePassed(task);
    }

    private boolean hasBeenClosed(Task task) {
        return task.closeDate().isEmpty();
    }

    private boolean hasDueDate(Task task) {
        return task.dueDate().isPresent();
    }

    private boolean dueDatePassed(Task task) {
        return task.dueDate().get().isBefore(ZonedDateTime.now());
    }
}
