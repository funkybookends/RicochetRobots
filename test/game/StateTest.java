/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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
        Board board = null;
        Robot robot = null;
        Direction dir = null;
        State instance = null;
        State expResult = null;
        State result = instance.getDecendant(board, robot, dir);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class State.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        State instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class State.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        State instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstructions method, of class State.
     */
    @Test
    public void testGetInstructions() {
        System.out.println("getInstructions");
        State instance = null;
        String expResult = "";
        String result = instance.getInstructions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class State.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        State instance = null;
        State expResult = null;
        State result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoveNumber method, of class State.
     */
    @Test
    public void testGetMoveNumber() {
        System.out.println("getMoveNumber");
        State instance = null;
        int expResult = 0;
        int result = instance.getMoveNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
