/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.TreeMap;

/**
 *
 * @author caspar
 */
public enum Robot {
    RED   ('R', "Red"),
    BLUE  ('B', "Blue"),
    GREEN ('G', "Green"),
    YELLOW('Y', "Yellow");
    
    private static TreeMap<Character, Robot> index;
    
    protected final char label;
    private final String name;
    
    Robot (char label, String name){
        this.label = label;
        this.name = name;
    }
    
    public String toString(){
        return Character.toString(label);
    }
    
    public String getName(){
        return this.name;
    }
    
    private static void buildIndex(){
        if (index == null){
            index = new TreeMap<>();
            for (Robot r : Robot.values()){
                index.put(r.label, r);
            }
        }
    }
    
    public static boolean isRobot(char robot){
        if (index == null) Robot.buildIndex();
        return index.containsKey(robot);
    }
    
    public static Robot getByLabel(char label){
        if (index == null) Robot.buildIndex();
        return index.get(label);
    }
   
}
