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
public class RichochetRobotsLine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        File f = new File("board2.txt");
        try {
            FileInputStream in = new FileInputStream(f);
            RicochetRobots b = new RicochetRobots(in);
            Solution sol = b.solve(Robot.RED, Target.getByLabel('a'));
            System.out.println(sol.toString());
            
        } catch (FileNotFoundException ex) {}
    }
}
