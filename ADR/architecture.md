# Architecture

* Status: Accepted

* Deciders: Noé Larrieu-Lacoste Pierre Ebrahim Rémy Mashavoine Swann HERRERA

* Date: 2023-02-17

## Context and Problem Statement

We are at the start of the project and we want to create a solid code base, so that the application is maintainable.

Today, we want to run the application via the CLI, which is something that can potentially evolve.

We use the JSON data format and storage on a file on the user's machine. This is also something that could change.

These evolutions are related to the infrastructure of the application and do not concern the business logic.


## Decision Drivers

* Maintainability

* Openness to change

* A simple and standard CLI without putting too much emphasis on it.
 
* Do something fun because we're here to learn

## Considered Options

* Split domain and infra and exposition/cli

* Split domain and infra with just cli

* Split domain and infra and use event sourcing
 
* Include some CQRS

## Decision Outcome

We chose to split domain and infra, and to use exposition/cli.

We have ruled out the idea of event sourcing as it is not the goal here and we would like to take more time to practice with it.



### Positive Consequences

* Maintainability

### Negative Consequences

* Code is more complexe