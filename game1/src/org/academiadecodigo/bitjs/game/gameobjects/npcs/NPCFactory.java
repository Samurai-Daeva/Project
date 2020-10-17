package org.academiadecodigo.bitjs.game.gameobjects.npcs;

import org.academiadecodigo.bitjs.game.gameobjects.Character;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;

public class NPCFactory {


          public static Character getNewCharacter(Grid grid) {

               int random = (int) (Math.random() * NPCType.values().length);
               NPCType npcType = NPCType.values()[random];

               Character car;

               switch (npcType) {
                    case NPC1:
                         car = new Npc(grid.makeGridPosition(4,4, npcType.getPicture()));
                         break;
                    default:
                         car = new Npc(grid.makeGridPosition(10,5, npcType.getPicture()));
           /* default:
                car = new Player(grid.makeGridPosition(6,6));*/
               }

               return car;

          }

}

