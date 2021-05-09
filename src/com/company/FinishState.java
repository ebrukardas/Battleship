package com.company;


/**
 * "Finish" state of the game to check if the player win
 */
public class FinishState implements State{
    String state="";

    /**
     * Check if the player win
     *
     * @param player which player is in "the" state
     */
    @Override
    public void doAction(Player player) {
        if(player.checkShips() == true){
            state = "FinishState";
            player.setState(this);
        }else{
            state = "";
        }
    }

    @Override
    public String getState() {
        return state;
    }

    public String toString(){
        return "Finish State";
    }
}
