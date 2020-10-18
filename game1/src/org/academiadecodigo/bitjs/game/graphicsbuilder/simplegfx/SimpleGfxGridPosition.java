package org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.GridDirection;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.AbstractGridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGridPosition extends AbstractGridPosition {

    private int col;
    private int row;
    private Picture picture;
    private SimpleGfxGrid simpleGfxGrid;

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, Picture picture){
        super(col, row, grid);
        this.col = col;
        this.row = row;
        this.simpleGfxGrid = grid;
        this.picture = picture;
    }

    @Override
    public void show() {
        picture.draw();
    }
}
