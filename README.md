This was written for Compilers classes at University of Warsaw in winter 2010/2011, and was ranked ~75% (since it has a bug, only one backend and pretty much no optimization at all).

It's not something I would be particulary proud of, but I was asked about this code a lot so I publish it. 

The bug is in choice of environment used to evaluate expressions in function calls within the objects, if I remember correctly. 

Feel free to use it for educational purposes, but remember that parser-generator library ANTLR has been largely updated since then, and I am not sure if this a good example now. 

The language implemented was (sorry, no English desc.) http://www.mimuw.edu.pl/~ben/Zajecia/Mrj/Javalette/javalette.html.bak I was writing on Linux, with Eclipse and ANTLR plugins.
