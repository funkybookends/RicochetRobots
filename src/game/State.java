/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;


/**
 *
 * @author caspar
 */
public class State implements Iterable<Robot>{

    /**
     * The map of robots
     * 
     * A tree map since this is not likely to be large and a tree map would be 
     * quicker in that case
     */
    private TreeMap<Robot, Square> robots;
    
    protected State parent;
    
    //notes about it's parent
    protected int moveNumber = 0;    
    protected Robot movedRobot;
    protected Direction movedDir;
    
    /**
     * Constructor parses a board and finds the robot positions.
     * @param board the board to parse
     * @param insize the size of the inboard
     */
    protected State(char[][] board){
        int insize = board.length * 2 + 1 ;
        robots = new TreeMap<>();
        for (int i = 1; i < insize - 1; i+=2){
            for (int j =1; j < insize -1; j +=2){
                if (Robot.isRobot(board[i][j])){
                    Square loc = new Square(i/2,j/2);
                    char robotName = board[i][j];
                    robots.put(Robot.getByLabel(robotName), loc);
                }
            }
        }
    }
    
    public void setStartState(){
        parent = null;
        moveNumber = 0;
        movedRobot = null;
        movedDir = null;
    }
    
    private State(TreeMap<Robot, Square> robots){
        this.robots = robots;
    }
    
    public Square findRobot(Robot robot){
        return robots.get(robot);
    }
    
    @Override
    public Iterator<Robot> iterator() {
        return robots.keySet().iterator();
    }
    
    public String toString(){
        if (parent == null){
            return "Start - " + locs();
        }
        return ""+ moveNumber + ". " + movedRobot.name() + 
                " moved " + movedDir.toString() + " - " + locs();
    }
    
    private String locs(){
        StringBuilder out = new StringBuilder();
        for (Robot r: robots.keySet()){
            out.append(r.toString());
            out.append(robots.get(r).toString());
        }
        return out.toString();        
    }
    
    public State getDecendant(Board board, Robot robot, Direction dir){
        TreeMap<Robot, Square> newRobots = new TreeMap<>();
        for (Robot r: robots.keySet()) {
            if (r == robot) {
                newRobots.put(r, board.slide(r, dir, this));
            }
            else {
                newRobots.put(r, robots.get(r));
            }
        }
        State decendant = new State(newRobots);
        decendant.moveNumber = this.moveNumber+1;
        decendant.parent = this;
        decendant.movedRobot = robot;
        decendant.movedDir = dir;
        return decendant;        
    }
    
    public boolean equals(Object o){
        try {
            State other = (State) o;
            return this.locs().equals(other.locs());
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(toString());
        return hash;
    }
    
    public String getInstructions(){
        if (movedRobot == null) return "Initial State";
        return "Move '" + movedRobot + "' " + movedDir.toString();
    }

    public State getParent() {
        return this.parent;
    }

    public int getMoveNumber() {
        return this.moveNumber;
    }
        
}    
