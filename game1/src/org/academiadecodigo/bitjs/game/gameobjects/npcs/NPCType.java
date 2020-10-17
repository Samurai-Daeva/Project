package org.academiadecodigo.bitjs.game.gameobjects.npcs;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum NPCType {

    NPC1(new Picture(380,560, "resources/npc-1.png")),
    NPC2(new Picture(460,560,"resources/npc-2.png")),
    NPC3(new Picture(315,560,"resources/npc-3.png")),
    NPC4(new Picture(520,560,"resources/npc-4.png")),
    NPC5(new Picture(380,40, "resources/jojo.png")),
    NPC6(new Picture(320,40,"resources/9teen.png")),
    NPC7(new Picture(260,30,"resources/mari1.png")),
    NPC8(new Picture(200,30,"resources/g.png"));

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