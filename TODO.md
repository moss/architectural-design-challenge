* Now that a Rot13ApplicationFactory exists, use it to create the application for tests, too.
* Using the Rot13ApplicationFactory in tests probably means that we can do FakeOutput differently.
* Now reintroduce that old flush bug...
* ...and see if we can't catch it using acceptance tests.

A quick design sketch:
![The Application loads a file and an output source, and builds a Rot13Translator from them](http://www.diagrammr.com/png?key=dG6ESsAeogH)

The big discovery from the design sketch right now is that we're going to have a repository of some
sort to provide files, and an output source of some sort to print to. We can wire fake versions of
them into the acceptance test already, even without knowing quite what's demanded of them.