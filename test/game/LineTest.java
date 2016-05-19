/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
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
public class LineTest {
    
    public LineTest() {
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
     * Test of move method, of class Line.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        ArrayList<Integer> robotBarriers = new ArrayList<>();
        Integer origin = 4;
        boolean increasing = false;
        Line instance = new Line();
        instance.barriers.add(0);
        instance.barriers.add(7);
        Integer expResult = 0;
        Integer result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
        instance.barriers.add(1);
        expResult = 1;
        result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
        increasing = true;
        expResult = 6;
        result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
        
        origin=0;
        expResult=0;
        increasing = false;
        result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
        
        origin=6;
        expResult=6;
        increasing = true;
        result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
                
    }
    
    /**
     * Test of move method, of class Line.
     */
    @Test
    public void testMoveWithRobots() {
        System.out.println("move");
        ArrayList<Integer> robotBarriers = new ArrayList<>();
        robotBarriers.add(3);
        robotBarriers.add(2);
        robotBarriers.add(7);
        robotBarriers.add(6);
                
        Integer origin = 5;
        boolean increasing = false;
        Line instance = new Line();
        instance.barriers.add(0);
        instance.barriers.add(9);
        Integer expResult = 3;
        Integer result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
        expResult = 3;
        result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
        increasing = true;
        expResult = 5;
        result = instance.move(robotBarriers, origin, increasing);
        assertEquals(expResult, result);
    }
    
}
