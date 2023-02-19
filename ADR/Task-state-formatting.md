# TaskState Formatting

- Status: Accepted
- Deciders: Noé Larrieu-Lacoste, Pierre Ebrahim, Rémy Machavoine, Swann HERRERA
- Date: 2023-02-18

## Context and Problem Statement

We are adding some additional notes to the previously accepted ADR for TaskState Formatting.

## Decision Drivers

The original decision to use strings to represent the state of tasks was made to simplify the format and improve
maintainability.
In addition, we also considered the user experience and the ability to scale and add new states to the application in
the future.

## Considered Options

We considered using other data types, such as enums or boolean values, to represent the state of tasks.
However, we ultimately decided that strings were the most intuitive and flexible solution.

## Decision Outcome

By using strings to represent the state of tasks, we can easily add new states to the application in the future without
having to modify existing code.
This will make the code more scalable and easier to maintain.
In addition, using strings will also make it easier for new developers to understand the code and the different states
that objects can have.
Finally, this change will also improve the user experience by using more intuitive labels for the different states of
objects.

## Consequences:

While this change will improve the overall quality of the codebase, it will require some additional documentation and
training for new developers to understand the new system.
However, we believe that this is a worthwhile investment to improve the scalability and maintainability of the
application in the long term.