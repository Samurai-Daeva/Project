package org.academiadecodigo.bitjs.game;

// subclass of Enemy, in the constructor initializes the properties

public class PC extends Enemy {

    public PC(){
        setDamageCapacity(50);
        setDead(false);
        setHealth(500);
    }


}
