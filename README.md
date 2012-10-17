Warp
====

A 2D sidescroller based around stealth, assassinations, acrobatic puzzles, and time travel.

To Create a World
-----------------

First, subclass `ShiftWorld` with your own class, named something like *LevelJared* or *JaredLevel1*. Put this to the side right now.

Right click `EditorWorld` and hit `new EditorWorld()`. Put a bunch of stuff into this world. **NOTE:** *Where ever you place an object initially is its final location. Moving it around will not move it's actual location, because greenfoot hates us.

Anyway, when you have placed all of your ojbects (don't place the Player), right click and choose *Save the World*. This will save all of the objects in the current world into `EditorWorld`, specically into the `prepare` method. Copy this method to the subclass of `ShiftWorld` you created earlier. Presto, you have a level.

If you want to edit the placement of any objects, you need to readd the object in question to `EditorWorld`, do *Save the World* again, and re copy everything. Yes, this blows. We don't have a good way around it yet, but we are thinking of solutions. Plan on it being ready for the 60% prototype.

**IMPORTANT**: Do not commit changes to *EditorWorld.java*. When git complains about unstaged changes, just right click the file and choose git stash. This will stash the change away so that git ignores what you did to it for the purposes of commiting, pushing, and pulling.
