I'm setting out a few rules to follow as I do this, to concentrate my focus on the goals of the
exercise.

Planning
--------
* I will divide the work into small user stories with defined, user-reviewable acceptance criteria.
* I will work on one story at a time, and make sure it is complete before moving to the next.

Testing
-------
* I will write three classes of tests:
  * Unit tests
  * Focused integration tests
  * Acceptance tests
* Unit tests drive the design and implementation of code, without touching external resources.
* Integration tests drive the design and implementation code that touches external resources (I/O).
* New production code can only be written to make a unit test or focused integration test pass.
* A class that is covered by integration tests may not have unit tests, and vice versa.
* I will write an acceptance test at the start of each new story, to describe how it is to be used.
  * Implicit in the above rules: Unit tests drive code; acceptance tests drive unit tests.
* If a change ever causes a test to fail incorrectly, I will rewrite the test so that:
  * It passes after the change
  * It passes before the change
  * It will still fail if I remove the functionality it originally drove

Design
------
* I will never pass a primitive, number, string, or collection as a method parameter.
* I will never import a class or interface without using all of its public methods.
* I will never put two classes in the same package unless one uses the other.
* I will never put one package inside another unless the parent uses the child.
* I will never import from a package (in my code) into another that is not its parent.
  * I'm not at all confident of this rule or the last one--they're on trial.
* I will never use the new keyword and do a method call in the same class.
