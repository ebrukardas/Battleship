package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private List<Ship> ships;

    public Player(){
        state = null;
        ships = new ArrayList<>();
    }

    public void ShipSet(List<Ship> ships){
        this.ships.addAll(ships);

    }

    public boolean isHitSuccessfull(Coordinate coordinate){
        for (int i=0; i<ships.size(); ++i){
            //Ship s = ships.get(i);
            if(ships.get(i).gotHit(coordinate) == true){
                return true;
            }
        }
        return false;
    }

    public boolean checkShips(){
        int i=0;
        for (; i<ships.size(); ++i){
            if(ships.get(i).amISink() == false){
                return false;
            }
        }
        return true;
    }

    public void printTable(){
        char row = 'A';
        System.out.println("   0  1  2  3  4  5  6  7  8  9");
        for (int i=0; i<10; ++i){
            System.out.print( (row++) +" ");
            for (int j=0; j<10; ++j){
                Coordinate coordinate = new Coordinate(i,j);
                String flag = " - ";
                for (int k=0; k<ships.size(); ++k){
                    if(ships.get(k).isDeadPart(coordinate) == true){
                        flag = " H ";
                    }else if(ships.get(k).isSelectedPart(coordinate) == true){
                        flag = " S ";
                    }
                    /*else if(ships.get(k).isPart(coordinate) == true) {
                        flag = " X ";
                    }
                     */
                }
                System.out.print(flag);
            }
            System.out.println("");
        }
    }


    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    @Override
    public String toString() {
        String str = " ";
        for (int i=0; i<ships.size(); ++i){
            str += (ships.get(i).toString() + "\n");
        }
        return str;
    }
}
