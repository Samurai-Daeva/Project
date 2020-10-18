package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.gameobjects.Movement;
import org.academiadecodigo.bitjs.game.sound.src.org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

    public class GameMenu implements KeyboardHandler {

        private KeyboardEvent key_Q;
        private KeyboardEvent key_I;
        private boolean isOn;

        private Game game;

        private Sound menuMusic = new Sound("/resources/soundresources/menumusic.wav");

        public void init(){
            this.game = new Game(80, 25, 200);
            Picture picture = new Picture(10,10,"resources/startmenu.png");
            picture.draw();
            menuMusic.play(true);
            menuMusic.setLoop(4);
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
                menuMusic.close();
                Interaction.closeSounds();
                Movement.closeSound();
                System.exit(1);

            }else {
                if(isOn){
                    return;
                } else {
                    isOn = true;
                    game.init();
                    menuMusic.close();
                }
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }
}
