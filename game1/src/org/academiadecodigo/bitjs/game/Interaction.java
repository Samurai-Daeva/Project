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
        }
        return enemies;

    }

    public void attack(Player player, Enemy enemy, int levels, int enemyDamage) {

        player.setMCFight(true);
        if (Math.random() < 0.3) {
            player.damage(enemyDamage);
            hitPlayer.play(true);
        }
        enemy.damage(levels);
        hitEnemy.play(true);
    }

    public static void closeSounds() {
        hitPlayer.close();
        hitEnemy.close();
    }
}