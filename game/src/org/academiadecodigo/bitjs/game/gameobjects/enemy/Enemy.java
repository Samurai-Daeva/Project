package org.academiadecodigo.bitjs.game.gameobjects.enemy;

import org.academiadecodigo.bitjs.game.battle.Damage;

public class Enemy implements Damage {

    private int health;
    private boolean isDead;
    private int damageCapacity;

    //method that decides the amount of damage taken by the enemy
@Override
    public void damage(int damageCapacity){
        if(health >= 0) {
            health -= damageCapacity;
        } else {
            setDead(true);
        }
    }


    public boolean isDamaged(){

        return isDead;
    }

    public void setDead(boolean isDead){

        this.isDead = isDead;

    }

    public int getHealth(){
        return this.health;
    }

    public void setDamageCapacity(int damageCapacity) {
        this.damageCapacity = damageCapacity;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getDamageCapacity() {
        return damageCapacity;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "health=" + health +
                ", isDead=" + isDead +
                ", damageCapacity=" + damageCapacity +
                '}';
    }
}
