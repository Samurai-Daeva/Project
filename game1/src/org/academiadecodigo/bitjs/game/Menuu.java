package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.gameobjects.Movement;
import org.academiadecodigo.bitjs.game.sound.src.org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


    public class Menuu implements KeyboardHandler {

        private KeyboardEvent space;
        private KeyboardEvent key_1;
        private Game g;
        private Sound menuMusic = new Sound("/resources/soundresources/menumusic.wav");



        public void init(){
            this.g = new Game(80, 25, 200);
            Picture picture = new Picture(10,10,"resources/startmenu.png");
            picture.draw();
            menuMusic.play(true);
            menuMusic.setLoop(4);
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
                menuMusic.close();
                Interaction.closeSounds();
                Movement.closeSound();
                System.exit(1);
            }else {
                menuMusic.close();
                g.init();
            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
}
