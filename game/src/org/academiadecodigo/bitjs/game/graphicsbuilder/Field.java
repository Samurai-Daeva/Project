package org.academiadecodigo.bitjs.game.graphicsbuilder;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private final String name;
    private Picture field;
    private static final int PADDING = 10;

    public Field(String name){
        this.name = "field";
        this.field = new Picture(PADDING, PADDING, "resources/woodfloor.png");
    }

    public void init(){
        field.draw();
    }

    public String getName() {
        return name;
    }


}
