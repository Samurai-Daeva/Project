package org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx;

import org.academiadecodigo.bitjs.game.gameobjects.Player;
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
    private Picture[] sceneries = new Picture[17];


    private int counter;





    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        sceneries[0] = new Picture(PADDING, PADDING, "resources/woodfloor1.png");
        sceneries[1] = new Picture(PADDING, PADDING, "resources/combatmodeback.png");
        sceneries[2] = new Picture(PADDING, PADDING, "resources/combatmodeback1.png");
        sceneries[3] = new Picture(PADDING, PADDING, "resources/combatmodeback2.png");
        sceneries[4] = new Picture(PADDING, PADDING, "resources/combatmodeback3.png");
        sceneries[5] = new Picture(PADDING, PADDING, "resources/combatmodeback4.png");
        sceneries[6] = new Picture(PADDING, PADDING, "resources/combatmodeback5.png");
        sceneries[7] = new Picture(PADDING, PADDING, "resources/combatmodeback6.png");
        sceneries[8] = new Picture(PADDING, PADDING, "resources/combatmodeback18.png");
        sceneries[9] = new Picture(PADDING, PADDING, "resources/combatmodeback9.png");
        sceneries[10] = new Picture(PADDING, PADDING, "resources/combatmodeback11.png");
        sceneries[11] = new Picture(PADDING, PADDING, "resources/combatmodeback12.png");
        sceneries[12] = new Picture(PADDING, PADDING, "resources/combatmodeback13.png");
        sceneries[13] = new Picture(PADDING, PADDING, "resources/combatmodeback14.png");
        sceneries[14] = new Picture(PADDING, PADDING, "resources/combatmodeback15.png");
        sceneries[15] = new Picture(PADDING, PADDING, "resources/combatmodeback16.png");
        sceneries[16] = new Picture(PADDING, PADDING, "resources/combatmodeback17.png");


    }



    @Override
    public void init(){


        if (counter < sceneries.length) {
            Rectangle grid = new Rectangle(PADDING, PADDING, sceneries[counter].getMaxX() - PADDING, sceneries[counter].getMaxY() - PADDING);
            System.out.println(counter);
            grid.setColor(Color.BLACK);
            grid.draw();

            sceneries[counter].draw();
            System.out.println("hot");
            counter++;
            System.out.println(counter);
            return;

        }
        return;
    }



    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public int getRows() {
        return this.rows;
    }


    public int getX() {
        return PADDING;
    }

    public int getY() {
        return PADDING;
    }

    public int getCellSize() {
        return this.cellSize;
    }
    public int getCounter(){
        return counter;
    }

    /*public void setStart(boolean start) {
        this.start1 = start;
    }*/

    @Override
    public GridPosition makeGridPosition(int col, int row, Picture picture) {
        GridPosition gridPosition = new SimpleGfxGridPosition(col, row, this, picture);
        return gridPosition;
    }

    public int rowToY(int row) {

        return getY() + (row * getCellSize());

    }

    public int columnToX(int column) {
        return getX() + (column * getCellSize());


    }
}
