/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author caspar
 */
public enum Direction {    
    NORTH(false, false, "north"),
    EAST (true,  true , "east"),
    SOUTH(false, true , "south"),
    WEST (true,  false, "west");

    public final boolean movesOnRow;
    public final boolean increasing;
    public final String name;

    private Direction(boolean movesOnRow, boolean increasing, String name){
        this.movesOnRow = movesOnRow;
        this.increasing = increasing;
        this.name = name;
    }    
}
