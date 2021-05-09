package com.company;

/**
 * Submarine in the game
 */
public class Submarine extends Ship{

    /**
     * Constructor that takes ship size, start point and orientation
     *
     * @param startPoint  start point of the ship
     * @param orientation orientation of the ship i.e horizontal or vertical
     */
    public Submarine( Coordinate startPoint, char orientation) {
        super(1, startPoint, orientation);
    }

    /**
     * Get type of the ship which is Submarine
     * @return Ship type: Submarine
     */
    @Override
    public String getType() {
        return "SUBMARINE";
    }
}
