package org.academiadecodigo.bitjs.game.gameobjects.enemy;

// creates enemies accordingly the EnemyType passed as argument
public class EnemyFactory {

    public Enemy createEnemy(EnemyType enemyType) {
        switch (enemyType) {

            case MCJOJO:
                return new MCJojo();

            case MCRICARDO:
                return new MCRicardo();

            case MCMARI:
                return new MCMari();

            default:
                return new MCPedro();
        }
    }
}