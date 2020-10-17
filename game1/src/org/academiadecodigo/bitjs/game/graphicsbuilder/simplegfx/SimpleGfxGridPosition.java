package org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Picture picture;
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
        //this.picture = new Rectangle(grid.columnToX(super.getCol()),grid.rowToY(super.getRow()), grid.getCellSize(), grid.getCellSize() );
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
        this.picture = picture;//new Rectangle(grid.columnToX(col), grid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        //show();
    }


    @Override
    public void show() {
        picture.draw();
    }


    @Override
    public void hide() {
        picture.delete();
    }



    public void moveInDirection(GridDirection direction, int distance) {

        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance, picture.getHeight(), picture.getWidth());

        int dx = simpleGfxGrid.columnToX(getCol()) - simpleGfxGrid.columnToX(initialCol);
        int dy = simpleGfxGrid.rowToY(getRow()) - simpleGfxGrid.rowToY(initialRow);

        //int dx = simpleGfxGrid.columnToX(getCol()) - picture.getX();
        //int dy = simpleGfxGrid.rowToY(getRow()) - picture.getY();

        this.picture.translate(dx, dy);
    }




    public void setColor(Picture color) {

       /* switch (color){
            case BLUE:
                super.setColor(color);
                picture.setColor(Color.BLUE);
                break;
            case RED:
                super.setColor(color);
                picture.setColor(Color.RED);
                break;
            case GREEN:
                super.setColor(color);
                picture.setColor(Color.GREEN);
                break;
            case MAGENTA:
                super.setColor(color);
                picture.setColor(Color.MAGENTA);*/
        //color.draw();



    }

}