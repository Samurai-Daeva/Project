package org.academiadecodigo.bitjs.game.graphicsbuilder.grid;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Grid {
    void init();

    int getCols();

    int getRows();

    GridPosition makeGridPosition(int col, int row, Picture picture);
}
