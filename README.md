warp
====

A 2D sidescroller based around stealth, assassinations, acrobatic puzzles, and time travel.

To Create a World
-----------------

To create a world, first subclass `ShiftWorld`. Put this subclass to the side for now.

Open the greenfoot project and create a new `EditorWorld`. Generally, you want to right click and hit `fillBottom()` to crate a floor for the world. Go ahead and place platforms, enemies, and the like into the level.

When the level is done, right click and choose *Save the World*. This will create `prepare()` within `EditorWorld`. Copy `prepare()` to your custom class that you subclassed from `ShiftWorld`. Then add a call to `prepare()` into the constructor. If you select your custom level class and choose `new whateverLevel()`, you should see all of your objects arcoss the screen after you hit **start**. You can now test your level. To make changes, you need to go back to `EditorWorld` and make the changes there then recopy `prepare()`.

**IMPORTANT**: Do not commit EditorWorld.java to git. Nobody wants your EditorWorld that has all of your level's objects in it. We only want the clean version on github.com and the final version in your level class. If git is complaining about EditorWorld.java having been changed, ignore it. Do not commit it back to git.