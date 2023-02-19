# Architecture

- Status: Accepted
- Deciders: Noé Larrieu-Lacoste, Pierre Ebrahim, Rémy Machavoine, Swann HERRERA
- Date: 2023-02-17

## Context and Problem Statement

We are at the start of the project and we want to create a solid code base that is maintainable. Today, we want to run the application via the CLI, which is something that can potentially evolve. We use the JSON data format and storage on a file on the user's machine, which is also something that could change. These evolutions are related to the infrastructure of the application and do not concern the business logic.
Decision Drivers

- Maintainability
- Openness to change
- A simple and standard CLI without putting too much emphasis on it
- Doing something fun because we're here to learn

## Considered Options

- Split domain and infrastructure and exposition/CLI
- Split domain and infrastructure with just CLI
- Split domain and infrastructure and use event sourcing
- Include some CQRS

## Decision Outcome

We chose to split domain and infrastructure only for better comprehension and maintainability. We have ruled out the idea of event sourcing as it is not the goal here and we would like to take more time to practice with it.

### Positive Consequences

- Better maintainability
- More clarity in the code base

### Negative Consequences

- Code is more complex
- Could lead to a future refactoring if we want to add a new CLI or a web interface.