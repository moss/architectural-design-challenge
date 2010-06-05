* Possibly the FakeOutput can be simplified some after this.
* Review manually to confirm that it works okay.
* Is Rot13Application a little big now?

A quick design sketch:
![The Application loads a file and an output source, and builds a Rot13Translator from them](http://www.diagrammr.com/png?key=dG6ESsAeogH)

The big discovery from the design sketch right now is that we're going to have a repository of some
sort to provide files, and an output source of some sort to print to. We can wire fake versions of
them into the acceptance test already, even without knowing quite what's demanded of them.