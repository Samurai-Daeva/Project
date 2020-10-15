package org.academiadecodigo.bitjs;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Vector;

public class Field {

    private static final int PADDING = 10;
    private Picture field;

    public Field() {
        this.field = new Picture(PADDING,PADDING, "resources/Background.png");
    }

    public void init(){
        field.draw();
    }
}
