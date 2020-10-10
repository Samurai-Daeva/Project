package org.academiadecodigo.bitjs.game;

public class Game {

    private Player player;
    private Enemy[] enemies;
    private boolean complete;

    public Game(Player player) {
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

    public void attack(Player player, Enemy enemy) {

        for (int i = 0; i < enemies.length; i++) {


            double random = Math.random();

            if (random < 0.1) {

                System.out.println("miss.");

            } else if (random >= 0.1 && random <= 0.2) {

                player.damage(enemy.getDamageCapacity());
                System.out.println(player + " " + player.getHealth());
                System.out.println(enemy.getHealth());

            } else {

                while (!(enemy.isDamaged())) {

                    enemy.damage(player.getDamageCapacity());
                    System.out.println(enemy + " " + enemy.getHealth());
                    System.out.println(player.getHealth());

                }

            }

        }
    }

}


