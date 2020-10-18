package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


    public class Menuu implements KeyboardHandler {

        private KeyboardEvent space;
        private KeyboardEvent key_1;
        private Game g;



        public void init(){
            this.g = new Game(80, 25, 200);
            Picture picture = new Picture(10,10,"resources/startmenu.png");
            picture.draw();
            bootstrap();

        }

        private void bootstrap(){

            Keyboard keyboard = new Keyboard(this);

            space = new KeyboardEvent();
            space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            space.setKey(KeyboardEvent.KEY_Q);
            keyboard.addEventListener(space);

            key_1 = new KeyboardEvent();
            key_1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            key_1.setKey(KeyboardEvent.KEY_0);
            keyboard.addEventListener(key_1);
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
                System.exit(1);
            }else {
                g.init();
            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
}
