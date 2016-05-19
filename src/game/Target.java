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
public enum Target {
    RedPlanet   ('a', "Red Planet",    Robot.RED),
    RedStar     ('b', "Red Star",      Robot.RED),
    RedMoon     ('c', "Red Moon",      Robot.RED),
    RedCog      ('d', "Red Cog",       Robot.RED),
    
    YellowPlanet('e', "Yellow Planet", Robot.YELLOW),
    YellowStar  ('f', "Yellow Star",   Robot.YELLOW),
    YellowMoon  ('g', "Yellow Moon",   Robot.YELLOW),
    YellowCog   ('h', "Yellow Cog",    Robot.YELLOW),   
    
    GreenPlanet ('i', "Green Planet",  Robot.GREEN),
    GreenStar   ('j', "Green Star",    Robot.GREEN),
    GreenMoon   ('k', "Green Moon",    Robot.GREEN),
    GreenCog    ('l', "Green Cog",     Robot.GREEN),    
    
    BluePlanet  ('m', "Blue Planet",   Robot.BLUE),
    BlueStar    ('n', "Blue Star",     Robot.BLUE),
    BlueMoon    ('o', "Blue Moon",     Robot.BLUE),
    BlueCog     ('p', "Blue Cog",      Robot.BLUE),
    
    Vortex      ('q', "Vortex",        null);

    
    private static TreeMap<Character, Target> index;
    
    private final char label;
    private final String name;
    private final Robot visitor;
    private boolean visited = false;
    protected Square location;
    
    Target(char label, String name, Robot visitor){
        this.label = label;
        this.name = name;
        this.visitor = visitor;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String toString(){
        return Character.toString(label);
    }
    
    private static void buildIndex(){
        index = new TreeMap<>();
        for (Target t: Target.values()){
            index.put(t.label, t);
        }
    }
    
    public static Target getByLabel(char label) {
        if (index == null) Target.buildIndex();
        return index.get(label);
    }
    
    public static boolean isTarget(char label){
        if (index == null) Target.buildIndex();
        return index.containsKey(label);
    }

    protected void setLocation(Square location) {
        this.location = location;
    }
    
    public void setVisited(){
        this.visited = true;
    }

    public Square getLocation() {
        return this.location;
    }
    
    
}
