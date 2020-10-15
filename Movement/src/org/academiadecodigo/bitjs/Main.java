package org.academiadecodigo.bitjs;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        field.init();

        Player player = new Player();

        Movement game = new Movement(player);

        game.init();
    }
}
