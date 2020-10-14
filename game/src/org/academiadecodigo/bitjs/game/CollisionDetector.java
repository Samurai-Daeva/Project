package org.academiadecodigo.bitjs.game;

import org.academiadecodigo.bitjs.game.gameobjects.Character;
import org.academiadecodigo.bitjs.game.graphicsbuilder.grid.position.GridPosition;

public class  CollisionDetector {

    private Character[] cars;

    public CollisionDetector(Character[] cars) {
        this.cars = cars;
    }

    public boolean isUnSafe(GridPosition pos) {

        for (Character c : cars) {

            if (c.getPos()!= pos && c.getPos().equals(pos)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Checks for collisions with specific car
     * Requires iterating the array once
     * @param car
     */
    public void check(Character car) {

        for (Character ic : cars) {

            // No point in checking collisions with self
            if (ic == car) {
                continue;
            }

            if (ic.getPos().equals(car.getPos())) {
                ic.crash();
                car.crash();
            }
        }

    }

}
