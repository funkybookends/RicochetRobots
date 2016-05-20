/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richochetrobots;

import game.solver.Solution;
import game.Target;
import game.Robot;
import game.RicochetRobots;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author caspar
 */
public class RichochetRobotsApp {
    
    public static RicochetRobots getGameFromFile(String fileName)
            throws FileNotFoundException
    {
        File f = new File(fileName);
        FileInputStream in = new FileInputStream(f);
        return new RicochetRobots(in);
    }
    
    public static void test2() {
        try {            
            RicochetRobots b = getGameFromFile("board2.txt");
            Solution sol = b.solve(Robot.RED, Target.getByLabel('a'));
            System.out.println(sol.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("Fail - Could not load file - " + e.getMessage());
        }
    }
    
    public static void test3() {
        try {
            RicochetRobots b = getGameFromFile("board4.txt");
            Solution sol = b.solve(Robot.RED, Target.getByLabel('e'));
            System.out.println(sol.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("Fail - Could not load file - " + e.getMessage());
        }        
    }
    
    //Big 22 move solution, will not solve without heuristics
    public static void test22() {
        try {
            RicochetRobots b = getGameFromFile("board22.txt");
            Solution sol = b.solve(Robot.RED, Target.getByLabel('a'));
            System.out.println(sol.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("Fail - Could not load file - " + e.getMessage());
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test3();
    }
}
