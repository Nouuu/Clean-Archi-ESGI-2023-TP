# Input Output Exception

* Status: Accepted

* Deciders: Noé & Swann

* Date: 2023-02-17

## Context and Problem Statement

The filesystem is an external gateway and operation with it can failed.


## Decision Drivers

Today with the CLI if the inputs are not good it is not correct to stop the application flow.
But where would you like to evolve and put these constraints outside the domain layer

## Considered Options

* systeme exit

* throw generic exception

* throw custom excetion

## Decision Outcome

Throw custom exception
