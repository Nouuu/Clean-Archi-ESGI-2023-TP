# Input Output Exception

- Status: Accepted
- Deciders: Noé Larrieu-Lacoste, Pierre Ebrahim, Rémy Machavoine, Swann HERRERA
- Date: 2023-02-17

## Context and Problem Statement

The filesystem is an external gateway and operations with it can fail. When dealing with input/output operations, it is
important to handle errors and exceptions properly.

## Decision Drivers

We want to handle input/output exceptions in a way that does not stop the application flow, and we want to be able to
evolve and put these constraints outside the domain layer.

## Considered Options

- Use the system exit method to handle exceptions.
- Throw a generic exception when an input/output error occurs.
- Throw a custom exception when an input/output error occurs.

## Decision Outcome

We have decided to throw a custom exception when an input/output error occurs. This will allow us to handle these
exceptions in a more specific and controlled way.

### Positive Consequences

- Clearer and more specific exception handling.
- Better separation of concerns between the domain layer and input/output operations.
- More flexibility to evolve and modify the input/output operations in the future.

### Negative Consequences

- The code may become more complex if additional custom exceptions are introduced.