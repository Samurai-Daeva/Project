package org.academiadecodigo.bitjs.game.gameobjects.enemy;

// creates enemies accordingly do the EnemyType passed as argument

import org.academiadecodigo.bitjs.game.gameobjects.PC;

public class EnemyFactory {

    public Enemy createEnemy(EnemyType enemyType) {

        switch (enemyType) {
            case PC:
                return new PC();
            case MCJOJO:
                return new MCJojo();
            case MCMARI:
                return new MCMari();
            case MCPEDRO:
                return new MCPedro();
            default:
                return new MCRicardo();
        }
    }
}
