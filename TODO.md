* Extract something that reads input, translates, and writes output
* Extract/build a CompositeOutput
* Actually hook things up to write to the output file
* Finish wiring up the acceptance test, if it's not already done.
* Handle flushing correctly
  - Output files.
  - Anything else?
* Show friendly error if file already exists, rather than rewriting?
* Review code quality
* Fail on create files that already exist.
* Duplication in file path handling between Input and Output repositories.
* Handle failure to create new file.