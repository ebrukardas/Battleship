package com.company;


/**
 * "Take Turn" state of the game to take input from the player to hit the grid
 */
public class TakeTurnState implements State{

    /**
     * Take the coordinate from player to hit and says if it is successful or not
     *
     * @param player which player is in "the" state
     */
    @Override
    public void doAction(Player player) {
        Coordinate coor = new Coordinate(0,0);
        coor.takeCoordinate();
        if(player.isHitSuccessfull(coor) == true){
            System.out.println("Hit successful!");
        }else{
            System.out.println("Hit MISSED!");
        }
        player.setState(this);

    }

    @Override
    public String getState() {
        return "TakeTurnState";
    }


}
