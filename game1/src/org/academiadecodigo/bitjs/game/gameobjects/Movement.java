package org.academiadecodigo.bitjs.game.gameobjects;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Movement implements KeyboardHandler {

    private Player player;
    private KeyboardEvent up;
    private KeyboardEvent down;
    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent space;
    //esta key menu será o 0
    private KeyboardEvent esc;
    private KeyboardEvent key_1;
    private KeyboardEvent key_2;
    private KeyboardEvent key_3;
    private KeyboardEvent key_4;

    public Movement(Player player) {
        this.player = player;

    }

    public void init(){
        bootstrap();
    }

    private void bootstrap(){

        Keyboard keyboard = new Keyboard(this);

        up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

        space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

        esc = new KeyboardEvent();
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        esc.setKey(KeyboardEvent.KEY_0);
        keyboard.addEventListener(esc);

        key_1 = new KeyboardEvent();
        key_1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key_1.setKey(KeyboardEvent.KEY_1);
        keyboard.addEventListener(key_1);

        key_2 = new KeyboardEvent();
        key_2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key_2.setKey(KeyboardEvent.KEY_2);
        keyboard.addEventListener(key_2);

        key_3 = new KeyboardEvent();
        key_3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key_3.setKey(KeyboardEvent.KEY_3);
        keyboard.addEventListener(key_3);

        key_4 = new KeyboardEvent();
        key_4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key_4.setKey(KeyboardEvent.KEY_4);
        keyboard.addEventListener(key_4);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == up.getKey()){
            if(player.getInitialRow() < 20)
               return;
                player.moveUp();

        }

        if (keyboardEvent.getKey() == down.getKey()){
            if (player.getInitialRow() > 700)
                return;
            player.moveDown();
        }

        if (keyboardEvent.getKey() == right.getKey()){
            if (player.getInitialCol() > 550)
                return;
            player.moveRight();
        }

        if (keyboardEvent.getKey() == left.getKey()){
            if (player.getInitialCol() < 20)
                return;
            player.moveLeft();
        }

        if (keyboardEvent.getKey() == esc.getKey()){

            player.pushTalk();
        }

        if (keyboardEvent.getKey() == space.getKey()){
            player.setCodeUp(true);
            System.out.println("fff");
        }

        if (keyboardEvent.getKey() == key_1.getKey()){

            player.move1();
        }

        if (keyboardEvent.getKey() == key_2.getKey()){
            player.move2();
        }

        if (keyboardEvent.getKey() == key_3.getKey()){

            player.move3();
        }

        if (keyboardEvent.getKey() == key_4.getKey()){
            player.move4();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}