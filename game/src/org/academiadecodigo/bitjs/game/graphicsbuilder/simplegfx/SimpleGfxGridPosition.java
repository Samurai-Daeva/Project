package org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;


/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Picture rectangle;
    private SimpleGfxGrid simpleGfxGrid;
    private int col;
    private int row;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        this.simpleGfxGrid = grid;
        //this.rectangle = new Rectangle(grid.columnToX(super.getCol()),grid.rowToY(super.getRow()), grid.getCellSize(), grid.getCellSize() );
        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, Picture picture){
        super(col, row, grid);

        this.col = col;
        this.row = row;
        this.simpleGfxGrid = grid;
        System.out.println(grid.getCellSize());
        this.rectangle = picture;//new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        show();
    }


    @Override
    public void show() {
        rectangle.draw();
    }


    @Override
    public void hide() {
        rectangle.delete();
    }


    @Override
    public void moveInDirection(GridDirection direction, int distance) {


        int iniCol = getCol();
        int iniRow = getRow();

        switch (direction) {
            case RIGHT:
                moveRight(distance);
                rectangle.translate(simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(iniCol), 0);
                break;
            case LEFT:
                moveLeft(distance);
                rectangle.translate(simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(iniCol), 0);
                break;
            case UP:
                moveUp(distance);
                rectangle.translate(0, simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(iniRow));
                break;
            case DOWN:
                moveDown(distance);
                rectangle.translate(0, simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(iniRow));
        }
    }



    public void setColor(Picture color) {

       /* switch (color){
            case BLUE:
                super.setColor(color);
                rectangle.setColor(Color.BLUE);
                break;
            case RED:
                super.setColor(color);
                rectangle.setColor(Color.RED);
                break;
            case GREEN:
                super.setColor(color);
                rectangle.setColor(Color.GREEN);
                break;
            case MAGENTA:
                super.setColor(color);
                rectangle.setColor(Color.MAGENTA);*/
        color.draw();



    }

}