# Self-Editing-Code
A quick Java class that can append code to it's own file, then run itself again.

Runner will run the program. Effectively, the program will first run Iteration1. Then, it will ask for input. It'll then read it's own code, copy the input into the code in an appropriate place, then save the result as Iteration2. It'll then compile Iteration2 and run it.

The next iteration terminates the previous, deletes its files, then repeats the process.

The basic idea was to have code that could continually evolve without having to worry about saving all previous versions, which would use extraneous space. I was originally going to use it for a game that would let the user directly inject code into some limited parts of the game system for maximum customization.
