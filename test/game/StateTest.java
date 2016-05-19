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
     * Test of findRobot method, of class State.
     */
    @Test
    public void testFindRobot() {
        System.out.println("findRobot");
        Robot robot = null;
        State instance = null;
        Square expResult = null;
        Square result = instance.findRobot(robot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class State.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        State instance = null;
        Iterator<Robot> expResult = null;
        Iterator<Robot> result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class State.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        State instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
            
            assertEquals(1, result.getMoveNumber());
            assertEquals(robot, result.getMovedRobot());
            assertEquals(dir, result.getMovedDir());
            assertEquals(instance, result.getParent());
            
            Square exptdGreenLoc = new Square(0, 2);
            Square exptdRedLoc = new Square(0, 3);
            
            assertEquals(exptdRedLoc, result.findRobot(Robot.RED));
            assertEquals(exptdGreenLoc, result.findRobot(Robot.GREEN));

        }
        catch (FileNotFoundException e){
            fail("Could not open file");
            return;
        }
    }

    
    
}
