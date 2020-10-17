package org.academiadecodigo.bitjs.game.graphicsbuilder.grid;


import org.academiadecodigo.bitjs.game.gameobjects.Player;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Grid {


    public void init();


    public int getCols();

    public int getRows();

    public GridPosition makeGridPosition(int col, int row, Picture picture);

}
