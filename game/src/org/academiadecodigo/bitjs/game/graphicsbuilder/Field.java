package org.academiadecodigo.bitjs.game.graphicsbuilder;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Picture field;
    private static final int PADDING = 10;

    public Field(){

        this.field = new Picture(PADDING, PADDING, "game/resources/woodfloor.png");
    }

    public void init(){
        //Rectangle grid = new Rectangle(PADDING, PADDING, field.getMaxX() , field.getMaxY() - 50);
        Picture picture = new Picture(PADDING,PADDING,"game/resources/woodfloor.jpg");
        //grid.setColor(Color.BLACK);
        //grid.draw();
        picture.draw();
    }



}
