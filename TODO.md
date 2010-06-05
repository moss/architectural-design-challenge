* Bugfix from review: missing files are silently ignored.
  - Some investigation reveals that the problem was caused by not flushing the error output.
    Since I already solved this problem earlier, this suggests that there's some unfortunate
    duplication at work. Perhaps the logger should be using the same output object as the rest of
    the application?
  - Except there's not really a meaningful way to share the code that flushes after output. Boo.
* Better output for missing files?
* Give useful output when called with the wrong arguments?
* Review package structure. Where do the Fake IO classes belong?
* SystemOutput and ErrorLogger: feels like there's some redundancy and inconsistency there.

A quick design sketch:
![The Application loads a file and an output source, and builds a Rot13Translator from them](http://www.diagrammr.com/png?key=dG6ESsAeogH)

The big discovery from the design sketch right now is that we're going to have a repository of some
sort to provide files, and an output source of some sort to print to. We can wire fake versions of
them into the acceptance test already, even without knowing quite what's demanded of them.