Narrative: Convert files to ROT13
As an internet forum user discussing a recently released movie
I want to convert a file to rot13
So that I won't get yelled at for posting spoilers

Scenario: Convert a file to ROT13
Given a file "example.txt" containing "The dog barks at midnight."
When I execute "rot13 example.txt"
Then it should print "Gur qbt onexf ng zvqavtug."

Scenario: Show an error message when a file can't be found
When I execute "rot13 nonexistent-file.txt"
Then it should print "File not found: nonexistent-file.txt"