package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Start state of the game to take inputs of the ships
 */
public class StartState implements State{

    /**
     * Checks the coordinates are in use in the "ships"
     * @param ships information of ships
     * @param coordinate coordinate to check
     * @return true, if exist. otherwise false
     */
    private boolean contains(List<Ship> ships, Coordinate coordinate){
        for(int i=0; i<ships.size(); ++i){
            if(ships.get(i).contains(coordinate) == true){
                return true;
            }
        }
        return false;
    }

    /**
     * Take all inputs for 4 submarines, 3 destroyers, 2 cruisers and 1 battleship
     * from console
     *
     * @param player which player is in "the" state
     */
    @Override
    public void doAction(Player player) {
        List<Ship> ships = new ArrayList<>();
        input inp = null;
        player.setState(this);


        System.out.print("Enter 4 submarine ships information as described: ");
        for (int i=0; i<4; ++i){
            while (true){
                try{
                    inp = takeShipInputs();
                    if( contains(ships, new Coordinate(inp.x, inp.y)) == true ){
                        throw new IllegalArgumentException();
                    }
                    break;
                }catch (Exception e){
                    System.out.println("Ship exist. Try Again!");
                }
            }
            ships.add(new Submarine(new Coordinate(inp.x, inp.y), inp.orientation));
        }

        System.out.print("Enter 3 destroyer ships information as described: ");
        for (int i=0; i<3; ++i){
            while (true){
                try{
                    inp = takeShipInputs();
                    if( contains(ships, new Coordinate(inp.x, inp.y)) == true ){
                        throw new IllegalArgumentException();
                    }
                    break;
                }catch (Exception e){
                    System.out.println("Ship exist. Try Again!");
                }
            }
            ships.add(new Destroyer(new Coordinate(inp.x, inp.y), inp.orientation));
        }


        System.out.print("Enter 2 cruiser ships information as described: ");
        for (int i=0; i<2; ++i){
            while (true){
                try{
                    inp = takeShipInputs();
                    if( contains(ships, new Coordinate(inp.x, inp.y)) == true ){
                        throw new IllegalArgumentException();
                    }
                    break;
                }catch (Exception e){
                    System.out.println("Ship exist. Try Again!");
                }
            }
            ships.add(new Cruiser(new Coordinate(inp.x, inp.y), inp.orientation));
        }

        System.out.print("Enter 1 battleship information as described: ");
        while (true){
            try{
                inp = takeShipInputs();
                if( contains(ships, new Coordinate(inp.x, inp.y)) == true ){
                    throw new IllegalArgumentException();
                }
                break;
            }catch (Exception e){
                System.out.println("Ship exist. Try Again!");
            }
        }
        ships.add(new Battleship(new Coordinate(inp.x, inp.y), inp.orientation));

        player.ShipSet(ships);

    }

    @Override
    public String getState() {
        return "StartState";
    }

    /**
     * Input checks for the game board
     * @return inputs
     */
    private input takeShipInputs(){
        input inp = new input();
        Scanner input = new Scanner(System.in);
        String str = "";

        while (true) {
            str = input.next();
            try {
                System.out.print("> ");
                if (str.length() != 2) {
                    throw new IllegalArgumentException();
                }
                str = str.toUpperCase();
                char tempC = str.charAt(0);
                if(tempC<'A' || tempC>'J'){
                    throw new IllegalArgumentException("Coordinate -row- error ");
                }

                str = str.substring(1);
                int tempR = Integer.parseInt(str);
                if(tempR<0 || tempR>9){
                    throw new IllegalArgumentException("Coordinate -column- error ");
                }
                inp.x = tempC - 'A';
                inp.y = tempR;

                str = input.next();
                if(str.length() != 1){
                    throw new IllegalArgumentException("Orientation argument error");
                }
                str = str.toLowerCase();
                inp.orientation = str.charAt(0);

                if(inp.orientation!='v' && inp.orientation!='h'){
                    throw new IllegalArgumentException("Orientation argument error ");
                }

                break;
            } catch (Exception e) {
                System.out.print("Input error " + e.getMessage());
                System.out.println(". Try again");

            }
        }
        return inp;
    }

    class input{
        int x;
        int y;
        char orientation;
    }
    @Override
    public String toString(){
        return "Start State";
    }
}
