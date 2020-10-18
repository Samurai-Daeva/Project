package org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;

public interface GridPosition {
    int getCol();

    int getRow();

    void setPos(int col, int row);

    void show();

    void moveInDirection(GridDirection direction, int distance, int height, int width);

}
