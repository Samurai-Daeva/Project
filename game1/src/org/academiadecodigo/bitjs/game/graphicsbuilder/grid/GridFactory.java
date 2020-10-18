package org.academiadecodigo.bitjs.game.graphicsbuilder.grid;


import org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx.SimpleGfxGrid;

public class GridFactory {

    public static Grid makeGrid(int cols, int rows) {
        return new SimpleGfxGrid(cols,rows);
    }
}
