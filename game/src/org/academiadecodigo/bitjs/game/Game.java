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

    private Picture picture = new Picture(10, 600, "resources/totodile.png");

    //private Player player = new Player(grid.makeGridPosition(0,0, picture));
    private Player player;
    private int cols;
    private int rows;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */

    /**
     * Number of Characters to manufacture
     */
    private int manufacturedCharacters = 1;


    /**
     * Constructs a new game
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    Game(int cols, int rows, int delay) {

        //grid = GridFactory.makeGrid(cols, rows);
        this.cols = cols;
        this.rows = rows;
        this.delay = delay;


    }


    public void init() {
        grid = GridFactory.makeGrid(cols, rows);
        grid.init();
        player = new Player(grid.makeGridPosition(0,0, picture));

        if(!player.isCodeUp()){

        //this.player = new Player(grid.makeGridPosition(0,0, picture));



        characters = new Character[manufacturedCharacters];
        characters[0] = this.player;
        player = (Player) characters[0];
        for (int i = 1; i < manufacturedCharacters; i++) {

            characters[i] = NPCFactory.getNewCharacter(grid);
            characters[i].setGrid(grid);
            return;
        }
        }else{
            System.out.println("is code up");
            grid.init();
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