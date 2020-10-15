package org.academiadecodigo.bitjs.game;


import org.academiadecodigo.bitjs.game.gameobjects.Character;
import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.gameobjects.npcs.NPCFactory;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridFactory;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * The game logic
 */
public class Game {


    /**
     * Graphical field
     */
    private Grid grid;

    /**
     * Container of Characters
     */
    private Character[] characters;

    private Player player;

    private Picture picture = new Picture(0,0,"resources/player1.png");

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of Characters to manufacture
     */
    private int manufacturedCharacters = 1;


    /**
     * Constructs a new game
     * @param gridType which grid type to use
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }


    public void init() {

        grid.init();

        characters = new Character[manufacturedCharacters];
        collisionDetector = new CollisionDetector(characters);
        characters[0] = new Player(grid.makeGridPosition(0,0, picture),picture);
        player = (Player) characters[0];
        for (int i = 1; i < manufacturedCharacters; i++) {
            //if(cars[i] instanceof Car) {

            // Car car = (Car) cars[i];
            characters[i] = NPCFactory.getNewCharacter(grid);
            characters[i].setCollisionDetector(collisionDetector);
            characters[i].setGrid(grid);
        }
    }



    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);
/*
            player.pressDown();
            player.pressLeft();
            player.pressRight();
            player.pressUp();

 */
            //moveAllCars();

        }

    }

    /**
     * Moves all cars
     */
   /* public void moveAllCars() {
        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }
    }*/

}