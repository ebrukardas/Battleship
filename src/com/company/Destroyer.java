package com.company;

/**
 * Destroyer in the game
 */
public class Destroyer extends Ship{

    /**
     * Constructor that takes ship size, start point and orientation
     *
     * @param startPoint  start point of the ship
     * @param orientation orientation of the ship i.e horizontal or vertical
     */
    public Destroyer(Coordinate startPoint, char orientation) {
        super(2, startPoint, orientation);
    }

    /**
     * Get type of the ship which is Destroyer
     * @return Ship type: Destroyer
     */
    @Override
    public String getType() {
        return "DESTROYER";
    }
}
