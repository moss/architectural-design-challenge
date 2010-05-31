* Wire up Application.main()
* Do a test run of the application
* Handle exceptions while reading files.
* Don't forget to close the filereader when you're done.
* Any magic around flushing of output streams?
* Missing files?
* Should it be possible to use an Input more than once?
* Consider the duplication between InputTest and InputRepositoryContract. Anything to be done?
* Review rules--anything need refactoring?
* Configure what directory to read from

A quick design sketch:
![The Application loads a file and an output source, and builds a Rot13Translator from them](http://www.diagrammr.com/png?key=dG6ESsAeogH)

The big discovery from the design sketch right now is that we're going to have a repository of some
sort to provide files, and an output source of some sort to print to. We can wire fake versions of
them into the acceptance test already, even without knowing quite what's demanded of them.