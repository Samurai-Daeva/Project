package org.academiadecodigo.bitjs.game.gameobjects.npcs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum NPCType {

    NPC1(new Picture(4,4, "resources/npc1.png")),
    NPC2(new Picture(100,5,"resources/npc2.png"));


    private Picture picture;

    NPCType(Picture picture){
        this.picture = picture;
    }

    /**
     * Obtain the getColor associated with each car type
     *
     * @return the grid getColor
     */
    public Picture getPicture() {

        return this.picture;

    }
}