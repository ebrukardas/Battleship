package com.company;

/**
 * Battleship in the game
 */
public class Battleship extends Ship{
    /**
     * Constructor that takes ship size, start point and orientation
     *
     * @param startPoint  start point of the ship
     * @param orientation orientation of the ship i.e horizontal or vertical
     */
    public Battleship( Coordinate startPoint, char orientation) {
        super(4, startPoint, orientation);
    }

    /**
     * Get type of the ship which is Battleship
     * @return Ship type: Battleship
     */
    @Override
    public String getType() {
        return "BATTLESHIP";
    }
}
