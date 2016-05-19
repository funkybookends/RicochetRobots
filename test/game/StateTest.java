/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caspar
 */
public class StateTest {
    
    public StateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    

    /**
     * Test of getDecendant method, of class State.
     */
    @Test
    public void testGetDecendant() {
        System.out.println("getDecendant");
        try {
            char[][] charBoard = RicochetRobots.createCharBoard(
                    new FileInputStream( new File("board2.txt"))
                );
        
            Board board = new Board(charBoard);
            Robot robot = Robot.RED;
            Direction dir = Direction.NORTH;
            State instance = new State(charBoard);
            instance.setStartState();
            State result = instance.getDecendant(board, robot, dir);
            
            //check setStartState
            assertEquals(1, result.getMoveNumber());
            assertEquals(robot, result.getMovedRobot());
            assertEquals(dir, result.getMovedDir());
            assertEquals(instance, result.getParent());
            
            //check first move
            Square exptdGreenLoc = new Square(0, 2);
            Square exptdRedLoc = new Square(0, 3);            
            assertEquals(exptdRedLoc, result.findRobot(Robot.RED));
            assertEquals(exptdGreenLoc, result.findRobot(Robot.GREEN));
            
            
            //check same move results in same locs
            result = result.getDecendant(board, robot, dir);
            assertEquals(exptdRedLoc, result.findRobot(Robot.RED));
            assertEquals(exptdGreenLoc, result.findRobot(Robot.GREEN));            
            
            
            

        }
        catch (FileNotFoundException e){
            fail("Could not open file");
            return;
        }
    }

    
    
}
