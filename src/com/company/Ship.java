package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class to extend for ship types
 */
public abstract class Ship {
    private int size=0;
    private int hitParts=0;
    /**
     * All parts of the ship
     */
    private List<Coordinate> coordinates;
    /**
     * Dead parts of the ship
     */
    private List<Coordinate> deads;
    /**
     * Selected but not part of the ship
     */
    private List<Coordinate> selected;
    /**
     * orientation of the position
     * h: horizontal
     * v: vertical
     */
    private char orientation ;

    /**
     * Constructor that takes ship size, start point and orientation
     * @param size ship size
     * @param startPoint start point of the ship
     * @param orientation orientation of the ship i.e horizontal or vertical
     */
    public Ship(int size, Coordinate startPoint, char orientation ){
        if(size<=0 && (orientation=='v' || orientation=='h')){
            throw new IllegalArgumentException();
        }
        coordinates = new ArrayList<>();
        deads = new ArrayList<>();
        selected = new ArrayList<>();
        for (int i=0; i<size; ++i){
            Coordinate temp = null;
            if(orientation == 'v') {
                temp = new Coordinate(startPoint.getX()+i, startPoint.getY());
            }else if(orientation == 'h') {
                temp = new Coordinate(startPoint.getX() , startPoint.getY()+i);
            }
            coordinates.add(temp);
        }

        hitParts = 0;
        this.size = size;
        this.orientation = orientation;

    }

    /**
     * Constructor to use the ship parts with coordinates
     * @param coordinate
     */
    public Ship(Coordinate coordinate){
        this(1,coordinate, 'v');
    }

    /**
     * Checks whether the ship sank
     * @return true if the ship is sank, otherwise false
     */
    public boolean amISink(){
        if(coordinates.size() == 0)
            return true;
        return false;
    }

    /**
     * Is the given coordinate already hit
     * @param coordinate
     * @return true if the coordinate is dead
     */
    public boolean isDeadPart(Coordinate coordinate){
        return deads.contains(coordinate);
    }

    /**
     * Is the given coordinate already selected but not part of the ship
     * @param coordinate
     * @return true if the coordinate is selected
     */
    public boolean isSelectedPart(Coordinate coordinate){
        return selected.contains(coordinate);
    }

    /**
     * Is the given coordinate part of the ship
     * @param coordinate
     * @return true if the coordinate is a part
     */
    public boolean isPart(Coordinate coordinate){
        return coordinates.contains(coordinate);
    }

    /**
     * Checks the given coordinate is in the selected or part of the ship
     * @param coordinate
     * @return true if the coordinate is already choosen before
     */
    public boolean contains(Coordinate coordinate){
        return (selected.contains(coordinate) || coordinates.contains(coordinate));
    }

    /**
     * The ship got hit from the given coordinates
     * @param c coordinate to got hit from the player
     * @return
     */
    public boolean gotHit(Coordinate c){
        if(coordinates.size()!=0){
            for (int i = 0; i < coordinates.size(); ++i) {
                Coordinate tempCoor = coordinates.get(i);
                if (tempCoor.equals(c) == true) {
                    deads.add(c);
                    coordinates.remove(c);
                    ++hitParts;
                    return true;
                }
            }
        }
        selected.add(c);
        return false;
    }

    public abstract String getType();


    @Override
    public String toString() {
        String str = getType() + ": ";
        for(int i=0; i<coordinates.size(); ++i){
            str += coordinates.get(i).toString() + " ";
        }
        return str ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(coordinates, ship.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, hitParts, coordinates, orientation);
    }
}