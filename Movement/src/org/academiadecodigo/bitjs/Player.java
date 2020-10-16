package org.academiadecodigo.bitjs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture player;
    private Position position;

    public Player() {
        //this.player = new Picture(500, 500, "resources/player.png");
        this.player = new Picture(10, 600, "resources/totodile.png");
        position = new Position(player.getWidth(), player.getHeight());
        init();
    }

    public void init() {
        player.draw();
    }

    public void moveUp() {
        player.translate(0, -50);
        position.setRow(position.getRow() + 10);
    }

    public void moveDown() {
        player.translate(0, 50);
        position.setRow(position.getRow() - 10);
    }

    public void moveRight() {
        player.translate(50, 0);
        position.setCol(position.getCol() + 10);
    }

    public void moveLeft() {
        player.translate(-50, 0);
        position.setCol(position.getCol() - 10);
    }
    //usar em interact
    public void pushTalk() {
        player.translate(10, 0);
        position.setCol(position.getCol() + 10);
    }
    //usar abrir menu
    public void pushMenu() {
        player.translate(-10, 0);
        position.setCol(position.getCol() - 10);
    }
    //usar em swicht
    public void move1() {
        player.translate(10, 0);
        position.setCol(position.getCol() + 10);
    }
    //usar em swicht
    public void move2() {
        player.translate(-10, 0);
        position.setCol(position.getCol() - 10);
    }
    //usar em swicht
    public void move3() {
        player.translate(10, 0);
        position.setCol(position.getCol() + 10);
    }
    //usar em swicht
    public void move4() {
        player.translate(-10, 0);
        position.setCol(position.getCol() - 10);
    }

}
