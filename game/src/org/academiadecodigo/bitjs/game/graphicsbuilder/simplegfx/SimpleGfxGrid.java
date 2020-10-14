package org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private int x;
    private int y;
    private int cellSize = 20;


    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        Picture picture = new Picture(PADDING,PADDING,"game/resources/woodfloor.png");
        Rectangle grid = new Rectangle(PADDING, PADDING, picture.getMaxX() - PADDING, picture.getMaxY() - PADDING);

        grid.setColor(Color.BLACK);
        grid.draw();
        picture.draw();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return this.cols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return this.rows;
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return getCellSize() * this.cols;
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return getCellSize() * this.rows;
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return this.cellSize;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {

        return new SimpleGfxGridPosition(this);
    }



    @Override
    public GridPosition makeGridPosition(int col, int row, Picture picture) {
        GridPosition gridPosition = new SimpleGfxGridPosition(col,row,this, picture);
        return gridPosition;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {

        return getY() + (row * getCellSize());

    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return getX() + (column * getCellSize());


    }
}
