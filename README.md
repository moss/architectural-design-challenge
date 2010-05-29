An implementation of James Shore's
[Architectural Design Challenge](http://jamesshore.com/Blog/Architectural-Design-Challenge.html).

Some thoughts:
* I'm treating this as a constrained exercise, by adding a bunch of rules that I'm going to follow
  while doing it. The hope is that this will help test some of my intuitions about what makes for
  good design.
* I'm doing automated acceptance tests, despite the rule that end-to-end tests should be kept to a
  minimum. I find that they help structure my work on a story, and help explain what my code is
  there for.
* However, I think I'm going to try to avoid doing the acceptance tests as full end-to-end tests.
  Instead, I'm going to set up a fake I/O environment for them to run in, with contract tests to
  verify its functional equivalence to the real I/O environment.
* It's probably worth noting that I probably haven't delivered any business value until all my first
  four stories are done. The first four together add up to an MMF, as it were. It still seems worth
  having them in there, to get started reviewing functionality and thinking about architecture as
  early as possible.