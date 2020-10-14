package org.academiadecodigo.bitjs.game.graphicsbuilder.grid;


import org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx.SimpleGfxGrid;

/**
 * A factory of different types of grids
 */
public class GridFactory {

    /**
     * Creates a new grid
     *
     * @param gridType the type of grid to create
     * @param cols     the number of columns of the grid
     * @param rows     the number of rows of the grid
     * @return the new grid
     */
    public static Grid makeGrid(GridType gridType, int cols, int rows) {


                return new SimpleGfxGrid(cols,rows);


    }

}
