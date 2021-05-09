package com.company;

import java.util.Objects;
import java.util.Scanner;

/**
 * Coordinate for game board
 */
public class Coordinate {
    private int x=0;
    private int y=0;

    /**
     * Construction to take x and y values
     * @param x
     * @param y
     */
    public Coordinate(int x, int y){
        changePosition(x,y);
    }

    public void changePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Take coordinate from the user on console
     * i.e H8
     */
    public void takeCoordinate(){
        String str = "";
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter coordinate > ");
            str = input.next();
            try {
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
                x = tempC - 'A';
                y = tempR;
                break;
            } catch (Exception e) {
                System.out.println("Input error " + e.getMessage());
                System.out.println("Try again");

            }
        }
    }

    public int getX(){  return x; }

    public int getY(){  return y; }


    @Override
    public String toString() {
        return "[" +
                "" + x +
                ", " + y +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
