Scenario: Read and print a file (and then replace this scenario with the ROT13 one)
Given a file "example.txt" containing "The dog barks at midnight."
When I execute "rot13 example.txt"
Then it should print "The dog barks at midnight."

Scenario: Show an error message when a file can't be found
When I execute "rot13 nonexistent-file.txt"
Then it should print "File not found: nonexistent-file.txt"