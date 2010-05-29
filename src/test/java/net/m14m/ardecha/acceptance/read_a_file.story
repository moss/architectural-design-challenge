Scenario: Read and print a file (and then replace this scenario with the ROT13 one)
Given a file "example.txt" containing "The dog barks at midnight."
When I execute "rot13 example.txt"
Then it should print "The dog barks at midnight."
