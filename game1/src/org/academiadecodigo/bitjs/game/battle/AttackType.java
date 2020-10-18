package org.academiadecodigo.bitjs.game.battle;


    /*Defines the type of attack of the player and its intensity that goes as an
    argument in the enemy damage()*/
public enum AttackType {
    ATTACK1(300),
    ATTACK2(500),
    ATTACK3(1000);

    private int damage;

    AttackType(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }
}
