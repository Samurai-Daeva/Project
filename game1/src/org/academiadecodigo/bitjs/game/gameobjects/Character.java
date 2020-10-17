package org.academiadecodigo.bitjs.game.gameobjects;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;

public class Character {

    private GridPosition pos;
    private Grid grid;

    private boolean crashed = false;

    //protected CollisionDetector collisionDetector;
    protected GridDirection currentDirection;

    public Character(GridPosition pos){
        this.pos = pos;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPos() {
        return pos;
    }

   /* public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }*/

  /*  public void setDirectionChangeLevel(int directionChangeLevel) {
        this.directionChangeLevel = directionChangeLevel;
    }*/

    public boolean isCrashed() {
        return crashed;
    }

    /**
     * Sets the car into a crashed state
     */
    public void crash() {

        this.crashed = true;
        // pos.setColor(GridColor.RED);

    }
    public boolean isHittingWall() {

        switch (currentDirection) {
            case LEFT:
                if (getPos().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPos().getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (getPos().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (getPos().getRow() == grid.getRows() - 1) {
                    return true;
                }
        }

        return false;

    }
}
