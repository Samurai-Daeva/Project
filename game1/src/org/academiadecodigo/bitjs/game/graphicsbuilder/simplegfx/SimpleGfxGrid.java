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
    Picture firstScene;
    Picture[] sceneries = new Picture[7];
    //String[] sceneries = {"game/resources/Background.png", "game/resources/combatmodeback.png}"};
    private int counter;
    private int regulator;


    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        sceneries[0] = new Picture(PADDING, PADDING, "resources/Background.png");
        sceneries[1] = new Picture(PADDING, PADDING, "resources/combatmodeback.png");
        sceneries[2] = new Picture(PADDING, PADDING, "resources/combatmodeback1.png");
        sceneries[3] = new Picture(PADDING, PADDING, "resources/combatmodeback2.png");
        sceneries[4] = new Picture(PADDING, PADDING, "resources/combatmodeback3.png");
        sceneries[5] = new Picture(PADDING, PADDING, "resources/combatmodeback4.png");
        sceneries[6] = new Picture(PADDING, PADDING, "resources/combatmodeback5.png");

    }

    @Override
    public void init() {

        if (counter < sceneries.length) {
            Rectangle grid = new Rectangle(PADDING, PADDING, sceneries[counter].getMaxX() - PADDING, sceneries[counter].getMaxY() - PADDING);
            System.out.println(counter);
            grid.setColor(Color.BLACK);
            grid.draw();
            if (regulator % 2 != 0) {
                sceneries[1].draw();
                System.out.println("het");
                regulator++;
            } else {
                sceneries[counter].draw();
                System.out.println("hot");
                counter++;
            }
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

    public int getWidth() {
        return getCellSize() * this.cols;
    }

    public int getHeight() {
        return getCellSize() * this.rows;
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
