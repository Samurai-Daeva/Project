package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.gameobjects.PC;
import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.Enemy;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.EnemyFactory;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.EnemyType;

public class Interaction {

    private Player player;
    private Enemy[] enemies;
    private boolean complete;
    private int counter;

    public Interaction(Player player) {
        this.enemies = new Enemy[9];
        this.player = player;
    }

    /* method that puts enemies in an array that were created in the enemy factory.
        Creates a PC in the index 0 and 1 and then sort them evenly. Returns an array of enemies*/
    public Enemy[] sortEnemies() {

        EnemyFactory enemyFactory = new EnemyFactory();
        int counter = 1;

        for (int i = 1; i < enemies.length; i++) {

            enemies[0] = enemyFactory.createEnemy(EnemyType.values()[0]);

            if (i % 2 != 0) {

                enemies[i] = enemyFactory.createEnemy(EnemyType.values()[0]);

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
                if(enemy instanceof PC) {
                    if (Math.random() < 0.2) {
                        player.damage(enemyDamage);
                        System.out.println(player + " " + player.getHealth());
                        System.out.println(enemy.getHealth());
                    }
                    enemy.damage(levels);
                    System.out.println(enemyDamage);
                } else {
                    player.setMCFight(true);
                    if (Math.random() < 0.2) {
                        player.damage(enemyDamage);
                        System.out.println(player.getDamageCapacity());
                    }
                    enemy.damage(levels);
                    System.out.println(enemy + " " + enemy.getHealth());
                    System.out.println(player.getHealth());
                }
                }

            }







