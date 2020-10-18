package org.academiadecodigo.bitjs.game.gameobjects;

import org.academiadecodigo.bitjs.game.Game;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;
import org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bitjs.game.graphicsbuilder.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.bitjs.game.sound.src.org.academiadecodigo.bootcamp.Sound;
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
    private boolean MCFight;
    private Movable movable;
    private Keyboard keyboard;
    private Picture playerPicture;
    private Picture wrong = new Picture(10, 10, "resources/wrong.png");
    private Picture talk1 = new Picture(250, 10, "resources/ballon.png");
    private Picture talk2 = new Picture(500, 500, "resources/ballon.png");
    private Sound ambience = new Sound("/resources/soundresources/roommusic.wav");
    private Sound computerAmbience = new Sound("/resources/soundresources/computer.wav");




    private GridPosition pos;
    private SimpleGfxGrid grid;
    private SimpleGfxGridPosition gfxposition;
    private int initialCol = 0;
    private int initialRow = 200;

    private Movement movement;


    public Player(GridPosition pos) {
        super(pos);
        this.pos = pos;
        this.keyboard = new Keyboard(this);
        this.health = 1000;
        this.isDead = false;
        this.damageCapacity = 300;


        this.level1 = false;
        this.level2 = false;
        this.level3 = false;
        this.codeUp = false;
        this.playerPicture = new Picture(10, 450, "resources/player2.png");
        this.grid = new SimpleGfxGrid(600, 750);
        this.gfxposition = new SimpleGfxGridPosition(0, 0, grid, playerPicture);
        this.movable = playerPicture;


        init();
    }

    public void init() {
        movement = new Movement(this);
        movement.init();
        playerPicture.draw();
        ambience.play(true);
        ambience.setLoop(10);
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


    @Override
    public String toString() {
        return this.name;
    }

    public void moveUp() {

        playerPicture.translate(0, -10);

        initialRow -= 10;
        System.out.println("Row " + initialRow);

    }

    public void moveDown() {

        playerPicture.translate(0, 10);
        initialRow += 10;
        System.out.println("Row " + initialRow);

    }

    public void moveRight() {

        playerPicture.translate(10, 0);
        initialCol += 10;
        System.out.println("Col " + initialCol);

    }

    public void moveLeft() {

        playerPicture.translate(-10, 0);
        initialCol -= 10;
        System.out.println("Col " + initialCol);

    }

    //usar em interact
    public void pushTalk() {
       // grid.setStart(true);
        if (grid.getCounter() == 0 || grid.getCounter() == 1 || grid.getCounter() == 2 || grid.getCounter() == 3 || grid.getCounter() == 4 || grid.getCounter() == 5 || grid.getCounter() == 8 || grid.getCounter() == 13 || grid.getCounter() == 16) {
            grid.init();
        } else {
            return;
        }
    }


    //usar em swicht
    public void move1() {
        if (grid.getCounter() == 6) {
            grid.init();
        } else if (grid.getCounter() == 9) {
            System.out.println("keypress1");
            Game.interact();
        } else if (grid.getCounter() == 7 || grid.getCounter() == 10 || grid.getCounter() == 12 || grid.getCounter() == 15) {
            wrong.draw();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("something's wrong");
            }
            if(health <= 0){
                setDead(true);
                computerAmbience.close();
            }
            else{
                health -= 100;
            }
        } else {
            return;
        }
    }

    //usar em swicht
    public void move2() {
        if (grid.getCounter() == 7 || grid.getCounter() == 12) {
            grid.init();
        } else if (grid.getCounter() == 11) {
            Game.interact();
        } else if (grid.getCounter() == 6 || grid.getCounter() == 10 || grid.getCounter() == 15) {
            wrong.draw();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("something's wrong");
            }
            // grid.init(15);
            if(health <= 0){
                setDead(true);
                computerAmbience.close();
            }
            else{
                health -= 100;
            }
            System.out.println(health);
        } else {
            return;
        }
    }

    //usar em swicht
    public void move3() {
        if (grid.getCounter() == 10) {
            grid.init();
        } else if (grid.getCounter() == 14) {
            Game.interact();
        } else if (grid.getCounter() == 6 || grid.getCounter() == 7 || grid.getCounter() == 15 || grid.getCounter() == 12) {
            wrong.draw();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("something's wrong");
            }

            if(health <= 0){
                setDead(true);
                computerAmbience.close();
            }
            else{
                health -= 100;
            }

        } else {
            return;
        }
    }

    //usar em swicht
    public void move4() {
        if (grid.getCounter() == 15) {
            grid.init();
        } else if (grid.getCounter() == 17) {
            Game.interact();
        } else if (grid.getCounter() == 6 || grid.getCounter() == 10 || grid.getCounter() == 12 || grid.getCounter() == 7) {
            wrong.draw();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("something's wrong");
            }
            if(health <= 0){
                setDead(true);
                computerAmbience.close();
            }
            else{
                health -= 100;
            }
        } else {
            return;
        }
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

    public Picture getTalk() {
        return talk1;
    }

    public Picture getTalk2() {
        return talk2;
    }

    public SimpleGfxGrid getGrid() {
        return grid;

    }

    public boolean isDamaged() {

        return isDead;
    }

    public boolean isCodeUp() {

        return codeUp;
    }

    public boolean isLevel1() {
        return level1;
    }

    public boolean isLevel2() {
        return level2;
    }

    public boolean isLevel3() {
        return level3;
    }

    public void setCodeUp(boolean codeUp) {
        ambience.close();
        computerAmbience.play(true);
        computerAmbience.setLoop(10);
        this.codeUp = codeUp;

    }

    public void setDead(boolean isDead) {

        this.isDead = isDead;

    }

    public void setLevel1(boolean level1) {
        this.level1 = level1;
    }

    public void setLevel2(boolean level2) {
        this.level2 = level2;
    }

    public void setLevel3(boolean level3) {
        this.level3 = level3;
    }

    public void setMCFight(boolean mcFight) {
        this.MCFight = mcFight;
    }
}
