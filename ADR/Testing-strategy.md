# Testing Strategy

- Status: Accepted
- Deciders: Noé Larrieu-Lacoste, Pierre Ebrahim, Rémy Machavoine, Swann HERRERA
- Date: 2023-02-17

## Context and Problem Statement

At the start of the project, we are a team of 4 developers working simultaneously.

We have discussed the importance of establishing a testing strategy in order to ensure the quality and stability of our code base.

Also the code is pretty simple. It seems to be only CRUD operation.

## Decision Drivers

- Time constraints
- Project context
- The lack of stability at the beginning of the project
- The duration of the project

## Considered Options

- Test Driven Development (TDD)
- Test after development
- No testing

We have also multiple solution for the type of tests:

- Unit tests
- Integration tests
- End-to-end tests
- Acceptance tests



## Decision Outcome

After careful consideration, we have decided to start with a "test after development" approach. This will allow us to
work more quickly in the early stages of the project and to experiment with different design decisions without being
constrained by test requirements. However, we plan to transition to a TDD approach later in the project, if it continues
and becomes more stable.

For the testing strategy we will use a mix of unit tests and integration tests.
So we will try to test a full use case without interfering with the file system. (except for fixtures).

At first we have try to test with in memory testing but the domain is to simple. 

In our mind it is more relevant to test the repository with it, even if it is perhaps destined to change.
This strategy is linked to the time-security ratio of the test.
We don't have time to do a lot of testing and so we'll take an approach that is closer to real use case.

### Positive Consequences

- Faster development during early stages of the project
- Flexibility to experiment with different design decisions without being constrained by test requirements

### Negative Consequences

- Potential for bugs to be discovered later in the development process
- Possibility of coupling our code to the implementation, rather than to the desired functionality