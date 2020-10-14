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
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Character[] cars;

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
     * Number of cars to manufacture
     */
    private int manufacturedCars = 20;


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

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        grid.init();

        cars = new Character[manufacturedCars];
        collisionDetector = new CollisionDetector(cars);
        cars[0] = new Player(grid.makeGridPosition(0,0, picture),picture);
        player = (Player) cars[0];
        for (int i = 1; i < manufacturedCars; i++) {
            //if(cars[i] instanceof Car) {

            // Car car = (Car) cars[i];
            cars[i] = NPCFactory.getNewCharacter(grid);
            cars[i].setCollisionDetector(collisionDetector);
            cars[i].setGrid(grid);
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