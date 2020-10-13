package org.academiadecodigo.bitjs.game.gameobjects;

// subclass of Enemy, in the constructor initializes the properties

import org.academiadecodigo.bitjs.game.gameobjects.enemy.Enemy;

public class PC extends Enemy {

    public PC(){
        setDamageCapacity(50);
        setDead(false);
        setHealth(500);
    }


}
