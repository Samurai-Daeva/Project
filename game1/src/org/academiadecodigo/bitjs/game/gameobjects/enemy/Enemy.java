package org.academiadecodigo.bitjs.game.gameobjects.enemy;

import org.academiadecodigo.bitjs.game.battle.Damage;

public class Enemy implements Damage {

    private int health;
    private int damageCapacity;

    private boolean isDead;

    @Override
    public void damage(int damageCapacity){
        if(health >= 0) {
            health -= damageCapacity;

            if(health <= 0){
                setDead(true);
            }
        }
    }

    @Override
    public boolean isDamaged(){
        return isDead;
    }

    public void setDead(boolean isDead){
        this.isDead = isDead;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getDamageCapacity() {
        return damageCapacity;
    }

    public void setDamageCapacity(int damageCapacity) {
        this.damageCapacity = damageCapacity;
    }
}
