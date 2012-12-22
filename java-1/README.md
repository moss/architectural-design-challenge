An implementation of James Shore's
[Architectural Design Challenge](http://jamesshore.com/Blog/Architectural-Design-Challenge.html).

Some thoughts (updating this as I go):

* I initially tried treating this as a constrained exercise, writing up a bunch of rules to test my
  intuitions about what makes for good design. I've pretty much stopped checking the rules, though I
  think I'm staying close to them in spirit.
* I'm doing automated acceptance tests, despite the rule that end-to-end tests should be kept to a
  minimum. I find that they help structure my work on a story, and help explain what my code is
  there for.
* However, I've avoided doing the acceptance tests as full end-to-end tests. Instead, I set up a
  fake I/O environment for them to run in, with contract tests to verify its functional equivalence
  to the real I/O environment.
* It's probably worth noting that I probably haven't delivered any business value until all my first
  three stories are done. The first three together add up to an MMF, as it were. It still seems
  worth having them in there, to get started reviewing functionality and thinking about architecture
  as early as possible.
