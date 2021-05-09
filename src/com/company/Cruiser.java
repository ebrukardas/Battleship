package com.company;

/**
 * Cruiser in the game
 */
public class Cruiser extends Ship{
    /**
     * Constructor that takes Cruiser ship size, start point and orientation
     *
     * @param startPoint  start point of the ship
     * @param orientation orientation of the ship i.e horizontal or vertical
     */
    public Cruiser( Coordinate startPoint, char orientation) {
        super(3, startPoint, orientation);
    }

    /**
     * Get type of the ship which is Cruiser
     * @return Ship type: Cruiser
     */
    @Override
    public String getType() {
        return "CRUISER";
    }
}
