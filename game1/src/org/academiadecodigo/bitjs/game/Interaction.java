package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.Enemy;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.EnemyFactory;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.EnemyType;
import org.academiadecodigo.bitjs.game.sound.src.org.academiadecodigo.bootcamp.Sound;

public class Interaction {

    private Player player;
    private Enemy[] enemies;
    private static Sound hitEnemy = new Sound("/resources/soundresources/hitenemy.wav");
    private static Sound hitPlayer = new Sound("/resources/soundresources/hitplayer.wav");


    public Interaction(Player player) {
        this.enemies = new Enemy[EnemyType.values().length];
        this.player = player;
    }

    /* method that puts enemies in an array that were created in the enemy factory.
        Creates a PC in the index 0 and 1 and then sort them evenly. Returns an array of enemies*/
    public Enemy[] sortEnemies() {

        EnemyFactory enemyFactory = new EnemyFactory();
        int counter = 0;

        for (int i = 0; i < enemies.length; i++) {


            if (i % 2 != 0) {

                enemies[i] = enemyFactory.createEnemy(EnemyType.values()[counter]);
                counter++;

            } else {

                enemies[i] = enemyFactory.createEnemy(EnemyType.values()[counter]);
                counter++;

            }

            System.out.println(enemies[i]);
        }

        return enemies;

    }
    /*method that takes a player and an enemy as argument and invokes their methods of damage
    with a 10% chance of missing and a 80% advantage to the player*/

    public void attack(Player player, Enemy enemy, int levels, int enemyDamage) {

        player.setMCFight(true);
        if (Math.random() < 0.3) {
            player.damage(enemyDamage);
            hitPlayer.play(true);

            System.out.println(player.getDamageCapacity());
        }
        enemy.damage(levels);
        hitEnemy.play(true);
        System.out.println(enemy + " " + enemy.getHealth());
        System.out.println(player.getHealth());
    }


    public static void closeSounds() {
        hitPlayer.close();
        hitEnemy.close();
    }
}









