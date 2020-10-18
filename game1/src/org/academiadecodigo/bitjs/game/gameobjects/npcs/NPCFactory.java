package org.academiadecodigo.bitjs.game.gameobjects.npcs;

import org.academiadecodigo.bitjs.game.gameobjects.Character;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.Grid;

public class NPCFactory {

          public static Character getNewCharacter(Grid grid) {

               int random = (int) (Math.random() * NPCType.values().length);
               NPCType npcType = NPCType.values()[random];

               Character npc_s;

               switch (npcType) {
                    case NPC1:
                         npc_s = new Npc(grid.makeGridPosition(390,650, npcType.getPicture()));
                         break;

                    case NPC2:
                         npc_s = new Npc(grid.makeGridPosition(450,690, npcType.getPicture()));
                         break;

                    case NPC3:
                         npc_s = new Npc(grid.makeGridPosition(520,650, npcType.getPicture()));
                         break;

                         case NPC4:
                         npc_s = new Npc(grid.makeGridPosition(510,590, npcType.getPicture()));
                         break;

                    case NPC5:
                         npc_s = new Npc(grid.makeGridPosition(380,30, npcType.getPicture()));
                         break;

                    case NPC6:
                         npc_s = new Npc(grid.makeGridPosition(320,30, npcType.getPicture()));
                         break;

                    case NPC7:
                         npc_s = new Npc(grid.makeGridPosition(260,30, npcType.getPicture()));
                         break;

                    case NPC8:
                         npc_s = new Npc(grid.makeGridPosition(200,30, npcType.getPicture()));
                         break;

                    default:
                         npc_s = new Npc(grid.makeGridPosition(10,5, npcType.getPicture()));

               }
               return npc_s;

          }
}