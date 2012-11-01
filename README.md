Warp
====

A 2D sidescroller based around stealth, assassinations, acrobatic puzzles, and time travel.

To Create a World
-----------------

First, subclass `ShiftWorld` with your own class, named something like *LevelJared* or *JaredLevel1*. Put this to the side right now.

Right click `EditorWorld` and hit `new EditorWorld()`. Put a bunch of stuff into this world. **NOTE:** *Where ever you place an object initially is its final location. Moving it around will not move it's actual location, because greenfoot hates us.

Anyway, when you have placed all of your ojbects (don't place the Player), right click and choose *Save the World*. This will save all of the objects in the current world into `EditorWorld`, specically into the `prepare` method. Right click `TestWorld` and choose `new TestWorld()`. This will create a world using the prepare statement from the `EditorWorld`, but will add a player and include the proper screen dimensions.

If you want to edit the placement of any objects, you need to readd the object in question to `EditorWorld`, do *Save the World* again. 

**IMPORTANT**: Do not commit changes to *EditorWorld.java*. When git complains about unstaged changes, just right click the file and choose git stash. This will stash the change away so that git ignores what you did to it for the purposes of commiting, pushing, and pulling.

### Adding a Background

To add a background image to your level, open your level class and find the constructor. Change the constructor so that it has the following two lines, and looks similar to:

```` java
public LevelJared {
    super();

    Background bg = new Background("my_background.png");
    addObject(bg);

    // other stuff
}
````

**Note**: "my_backrground.png" is the name of a file inside the `images/` directory inside the greenfoot project folder.
