# HPI java capstone1 SquashIT
A little game created as part of the openHPI "Java Capstone Series Pt. 1" course using the Processing library

## The Game
**SquashIT** is a simple keyboard-controlled game written in Java using the *Processing framework*. To launch it, import the project, add the *core.jar* from the *Processing framework* to e.g. your Eclipse Build Path, and run *Main.java* located in the *game.starter* package. The game consists of a ball that moves across a game field and a paddle that's situated right above the game field's only pit. The goal is to prevent the ball from flying into the pit by blocking it with the paddle for as long as possible.

This initially easy task will become much more difficult as the ball gradually gains momentum, causing it to fly even faster across the game field. A timer in the top left corner counts the seconds the ball has survived without falling into the pit. A ball depot provides the player with exactly three balls which they can use to try for a best personal time. Once all of the balls are used up, the game is over and the best time out of the three attempts is displayed on the game over screen.

## Controls
The controls of this game are fairly simple: all you need is a keyboard with a space bar and the left and right arrow keys. Whenever there is no ball in the game, you can press the *space* bar to insert a new one, causing it to fly off towards the pit from the middle of the screen. The paddle is controlled using the *left* and *right* arrow keys, allowing it to move within the bounds of the game field. A step moves it exactly half its length at a time.  
**Hint:** Hold the *left* or *right* arrow key for a while to make the paddle move much faster!