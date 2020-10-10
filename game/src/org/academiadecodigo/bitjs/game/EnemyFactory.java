package org.academiadecodigo.bitjs.game;

// creates enemies accordingly do the EnemyType passed as argument

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
