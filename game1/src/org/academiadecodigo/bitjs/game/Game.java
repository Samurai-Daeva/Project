package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.battle.AttackType;
import org.academiadecodigo.bitjs.game.gameobjects.Character;
import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.Enemy;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.EnemyType;
import org.academiadecodigo.bitjs.game.gameobjects.npcs.NPCFactory;
import org.academiadecodigo.bitjs.game.gameobjects.npcs.NPCType;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridFactory;
import org.academiadecodigo.bitjs.game.sound.src.org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private int cols;
    private int rows;
    private int delay;
    private int manufacturedCharacters = 8 ;
    private static int counter;

    private static Grid grid;

    private Character[] characters;

    private static Picture picture = new Picture(10, 10, "resources/YouWin.png");
    private static Sound win = new Sound("/resources/soundresources/win.wav");


    private static Player player;

    private static Interaction interaction;

    private static Enemy[] enemies;

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

            for (int i = 0; i < manufacturedCharacters; i++) {
                characters[i] = NPCFactory.getNewCharacter(grid);
                characters[i].setGrid(grid);
                NPCType.values()[i].getPicture().draw();
                continue;
            }

        } else {
            interact();
        }
    }

    public static void interact() {
        if (counter < EnemyType.values().length) {
            if (player.isLevel1()) {
                if (!(enemies[counter].isDamaged())) {
                    interaction.attack(player, enemies[counter], AttackType.ATTACK1.getDamage(),
                        enemies[counter].getDamageCapacity());
                    return;
                }

                player.setLevel2(true);
                player.getGrid().init();
                counter++;

            } else if (player.isLevel2()) {
                if (!(enemies[counter].isDamaged())) {
                    interaction.attack(player, enemies[counter], AttackType.ATTACK2.getDamage(),
                        enemies[counter].getDamageCapacity());
                    return;
                }
                player.setLevel3(true);
                player.getGrid().init();
                counter++;

            } else if (player.isLevel3()) {
                if (!(enemies[counter].isDamaged())) {
                    interaction.attack(player, enemies[counter], AttackType.ATTACK3.getDamage(),
                        enemies[counter].getDamageCapacity());

                    return;
                }

            } else {
                if (!(enemies[counter].isDamaged())) {
                    interaction.attack(player, enemies[counter], player.getDamageCapacity(),
                        enemies[counter].getDamageCapacity());
                    return;

                } else {
                    player.setLevel1(true);
                    player.getGrid().init();
                    counter++;
                }
            }
        } else {
            player.getComputerAmbience().close();
            picture.draw();
            win.play(true);
        }
    }
}