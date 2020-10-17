package org.academiadecodigo.bitjs.game;


import org.academiadecodigo.bitjs.game.battle.AttackType;
import org.academiadecodigo.bitjs.game.gameobjects.Character;
import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.Enemy;
import org.academiadecodigo.bitjs.game.gameobjects.npcs.NPCFactory;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridFactory;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Grid grid;
    private Character[] characters;
    private Picture picture = new Picture(10, 600, "resources/totodile.png");
    private static Player player;
    private static Interaction interaction;
    private static Enemy[] enemies;
    private int cols = 80;
    private int rows = 25;
    private int delay = 200;
    private static int counter;

    private int manufacturedCharacters = 1;


    public Game(int cols, int rows, int delay) {


        this.cols = cols;
        this.rows = rows;
        this.delay = delay;
    }

    public void init() {
        grid = GridFactory.makeGrid(cols, rows);
        grid.init();
        player = new Player(grid.makeGridPosition(0, 0, picture));
        this.interaction = new Interaction(this.player);

        if (!player.isCodeUp()) {
            this.enemies = interaction.sortEnemies();
            characters = new Character[manufacturedCharacters];
            characters[0] = this.player;
            player = (Player) characters[0];
            for (int i = 1; i < manufacturedCharacters; i++) {

                characters[i] = NPCFactory.getNewCharacter(grid);
                characters[i].setGrid(grid);
                return;
            }
        } else {
            System.out.println("is code up");
            interact();
        }
    }

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

    public static void interact() {



            if (player.isLevel1()) {
                interaction.attack(player, enemies[counter], AttackType.ATTACK1.getDamage(), enemies[counter].getDamageCapacity());
                counter++;

            }
            if (player.isLevel2()) {
                interaction.attack(player, enemies[counter], AttackType.ATTACK2.getDamage(), enemies[counter].getDamageCapacity());
                counter++;
            }
            if (player.isLevel3()) {
                interaction.attack(player, enemies[counter], AttackType.ATTACK3.getDamage(), enemies[counter].getDamageCapacity());
                counter++;
            }
         interaction.attack(player, enemies[counter], player.getDamageCapacity(), enemies[counter].getDamageCapacity());
            counter++;

}

}