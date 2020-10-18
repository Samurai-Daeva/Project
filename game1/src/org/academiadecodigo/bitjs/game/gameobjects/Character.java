package org.academiadecodigo.bitjs.game.gameobjects;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;

public class Character {

    private Grid grid;

    private GridPosition pos;

    private boolean crashed = false;

    public Character(GridPosition pos){
        this.pos = pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
