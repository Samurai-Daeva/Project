package org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;

public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;

    private Grid grid;

    public AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance, int height, int width) {
        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }
    }

    protected void moveUp(int dist) {
        int maxRowsUp = Math.min(dist,getRow());
        setPos(getCol(), getRow() - maxRowsUp);

    }

    protected void moveDown(int dist) {
        int maxRowsDown = Math.min(getGrid().getRows() - (getRow() + 1),dist);
        setPos(getCol(), getRow() + maxRowsDown);

    }

    protected void moveLeft(int dist) {
        int maxRowsLeft = Math.min(dist,getCol());
        setPos(getCol() - maxRowsLeft, getRow());

    }

    protected void moveRight(int dist) {
        int maxRowsRight = Math.min(getGrid().getCols() - (getCol() + 1), dist);
        setPos(getCol() + maxRowsRight, getRow());
    }
}
