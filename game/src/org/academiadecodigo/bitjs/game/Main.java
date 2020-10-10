package org.academiadecodigo.bitjs.game;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Tofu");
        Enemy[] enemies;

        Game game = new Game(player);

        enemies = game.sortEnemies();

        for (int i = 0; i < enemies.length; i++) {

            game.attack(player, enemies[i]);
        }
    }
}
