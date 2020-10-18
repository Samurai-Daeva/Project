package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

    public class GameMenu implements KeyboardHandler {

        private KeyboardEvent key_Q;
        private KeyboardEvent key_I;
        private Game game;

        public void init(){
            this.game = new Game(80, 25, 200);
            Picture picture = new Picture(10,10,"resources/startmenu.png");
            picture.draw();
            bootstrap();

        }

        private void bootstrap(){
            Keyboard keyboard = new Keyboard(this);

            key_Q = new KeyboardEvent();
            key_Q.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            key_Q.setKey(KeyboardEvent.KEY_Q);
            keyboard.addEventListener(key_Q);

            key_I = new KeyboardEvent();
            key_I.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            key_I.setKey(KeyboardEvent.KEY_I);
            keyboard.addEventListener(key_I);
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q){
                System.exit(1);

            }else {
                game.init();
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }
}
