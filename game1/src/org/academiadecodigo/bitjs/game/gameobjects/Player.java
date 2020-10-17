package org.academiadecodigo.bitjs.game.gameobjects;

import org.academiadecodigo.bitjs.game.Game;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;
import org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.bitjs.game.battle.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.Position;


public class Player extends Character implements Damage, KeyboardHandler {

    private int health;
    private boolean isDead;
    private int damageCapacity;
    private String name;
    private boolean level1;
    private boolean level2;
    private boolean level3;
    private boolean codeUp;
    private boolean MCFight;
    private Movable movable;
    private Keyboard keyboard;
    private Picture playerPicture;
    private Position position;
    private GridPosition pos;
    private SimpleGfxGrid grid ;
    private SimpleGfxGridPosition gfxposition ;
    private int initialCol = 0;
    private int initialRow = 200;
  
    private Movement movement;


    public Player(GridPosition pos) {
        super(pos);
        this.pos = pos;
        this.keyboard = new Keyboard(this);
        this.health = 2000;
        this.isDead = false;
        this.damageCapacity = 300;
        this.name = name;

        this.level1 = false;
        this.level2 = false;
        this.level3 = false;
        this.codeUp = false;
        this.playerPicture= new Picture(10, 450, "resources/player2.png");
        this.grid = new SimpleGfxGrid(600, 750);
        this.gfxposition = new SimpleGfxGridPosition(0, 0, grid, playerPicture);
        this.movable = playerPicture;

      
        init();
    }

    public void init() {
        movement = new Movement(this);
        movement.init();
        playerPicture.draw();
    }

    public Picture getPlayerPicture() {
        return playerPicture;
    }

    public boolean isCodeUp() {

        return codeUp;
    }

    public boolean isLevel1(){
        return level1;
    }

    public boolean isLevel2() {
        return level2;
    }

    public boolean isLevel3() {
        return level3;
    }

    // method that decides the amount of damage taken by the player
    @Override
    public void damage(int damageCapacity) {

        if (codeUp) {
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
    public void keyPressed(KeyboardEvent keyboardEvent) {
        movement.keyPressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isDamaged() {

        return isDead;
    }

    public void setCodeUp(boolean codeUp) {

        this.codeUp = codeUp;
        grid.init();
    }

    public void setDead(boolean isDead) {

        this.isDead = isDead;

    }
    public void setMCFight(boolean mcFight){
        this.MCFight= mcFight;
    }

    public int getInitialCol() {
        return initialCol;
    }

    public int getInitialRow() {
        return initialRow;
    }

    public int getDamageCapacity() {
        return damageCapacity;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void moveUp() {
  
        playerPicture.translate(0, -10);

        initialRow -= 10;
        System.out.println("Row " +initialRow);

    }

    public void moveDown() {

         playerPicture.translate(0,  10);
         initialRow += 10;
        System.out.println("Row "+ initialRow);

    }

    public void moveRight() {

         playerPicture.translate(10, 0);
         initialCol += 10;
        System.out.println("Col " + initialCol);

    }

    public void moveLeft() {

         playerPicture.translate( - 10, 0);
         initialCol -= 10;
        System.out.println("Col " + initialCol);

    }

    //usar em interact
    public void pushTalk() {
        playerPicture.translate(10, 0);
        position.setCol(position.getCol() + 10);
    }

    //usar abrir menu
    public void pushMenu() {
        playerPicture.translate(-10, 0);
        position.setCol(position.getCol() - 10);
    }

    //usar em swicht
    public void move1() {
        System.out.println("keypress1");
     Game.interact();
    }

    //usar em swicht
    public void move2() {
        if(MCFight && !level1){
            return;
        }else if(MCFight && level1){
            Game.interact();
        } return;
    }

    //usar em swicht
    public void move3() {
        if(MCFight && !level2){
            return;
        }else if(MCFight && level2){
            Game.interact();
        } return;

    }

    //usar em swicht
    public void move4() {
        if(MCFight && !level3){
            return;
        }else if(MCFight && level3){
            Game.interact();
        } return;

    }

}
