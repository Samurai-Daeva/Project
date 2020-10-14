package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.gameobjects.enemy.Enemy;
import org.academiadecodigo.bitjs.game.graphicsbuilder.Field;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridType;

public class Main {

    public static void main(String[] args) {

        Game g = new Game(GridType.SIMPLE_GFX, 80, 25, 200);

        g.init();
        //g.start();


        //Field field = new Field();
        //field.init();


    }
}
