package org.academiadecodigo.bitjs.game.gameobjects;

import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.bitjs.game.battle.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Character implements Damage, KeyboardHandler {

    private int health;
    private boolean isDead;
    private int damageCapacity;
    private String name;
    private boolean level1;
    private boolean level2;
    private boolean level3;
    private boolean codeUp;
    private Movable movable;
    private Keyboard keyboard;
    private Picture picture;

    public Player(GridPosition pos, Picture picture) {
        super(pos);
        this.movable = picture;
        this.keyboard = new Keyboard(this);
        this.picture = picture;
        this.health = 2000;
        this.isDead = false;
        this.damageCapacity = 300;
        this.name = name;
        this.level1 = false;
        this.level2 = false;
        this.level3 = false;
        this.codeUp = true;

    }

    public Picture getPicture() {
        return picture;
    }

    // method that decides the amount of damage taken by the player
@Override
    public void damage(int damageCapacity){

        if(codeUp) {
            if (this.health >= 0) {
                this.health -= damageCapacity;
            } else {
                setDead(true);
                codeUp = false;
            }
        } else {
            System.out.println("I can't do that.");
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

    }

    public boolean isDamaged(){

        return isDead;
    }

    public void setDead(boolean isDead){

        this.isDead = isDead;

    }

    public int getDamageCapacity(){
        return damageCapacity;
    }

    public int getHealth(){
        return this.health;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
