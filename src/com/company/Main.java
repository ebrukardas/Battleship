package com.company;


public class Main {

    public static void main(String[] args) {

        Player a = new Player();
        Player b = new Player();
        int i=0;

        State state = new StartState();

        System.out.println("Welcome to the BATTLESHIP game.\n");
        System.out.println("There are two players to play, playground is 10x10");
        System.out.println("Every player enters ship information.");
        System.out.println("There are 4 submarines, 3 destroyers, 2 cruisers and a battleship");
        System.out.println("Ship information needed as > RowColumn V/H");
        System.out.println("For example: A8 v for start point (A,8) and vertical");


        System.out.println("\nPLAYER A");
        state.doAction(a);
        System.out.println("PLAYER A Table: ");
        a.printTable();


        System.out.println("\nPLAYER B");
        state.doAction(b);
        System.out.println("PLAYER B Table: ");
        b.printTable();


        System.out.println("\n\n\nSTARTING PLAYING GAME");

        for(; i<100 && state.getState()!="FinishState"; ++i){
            state = new TakeTurnState();

            if(i%2==0){
                // PLAYER A TURNS

                System.out.println("\n\nPlayer A turns");
                b.printTable();

                state.doAction(b);
                state = new FinishState();
                state.doAction(b);

            }else{
                // PLAYER B TURNS

                System.out.println("\nPlayer B turns");
                a.printTable();

                state.doAction(a);
                state = new FinishState();
                state.doAction(a);

            }
        }
        if(i%2==1){
            System.out.println("Player A WON!");
        }else{
            System.out.println("Player B WON!");
        }

        System.out.println("GAME OVER");

    }

}
