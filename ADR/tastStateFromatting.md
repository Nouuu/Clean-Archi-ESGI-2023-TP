# TaskState Formatting

* Status: Accepted

* Deciders: Rémy Mashavoine, Swann HERRERA, Noé Larrieu-Lacoste, Pierre Ebrahim

* Date: 2023-02-18

## Context and Problem Statement

In our application, we currently have an ordinal system to represent the state of tasks.
However, this system is limited and can be confusing for developers and users of the application.


## Decision Drivers

* Simplicity of format

* Maintainability

## Considered Options

* Simple ordinal system

* Using string to store state

## Decision Outcome

We decided to change the ordinal system to use strings to represent the state of task.
This approach will clarify the meaning of the different object states and make the code easier to understand for developers.
Users of the application will also have a more intuitive experience when they see the different labels for object states.


By using strings, we can give meaningful and explicit names to the different object states, which will make it easier for developers to understand the code.
Strings are more intuitive for the users of the application, who will be able to understand the different states of the objects more easily.
This change will also make the code more scalable by allowing easy addition of new object states.

## Consequences:

This change will require some modification of existing code to update references to object states.
However, this should be a relatively simple and straightforward task.
Storing strings to represent object state may take slightly more storage space than the previous ordinal system,
but this should be negligible given the size of the application.
This decision will also require some documentation to explain the meaning of the various strings associated with object states,
to facilitate understanding for new developers joining the development team.