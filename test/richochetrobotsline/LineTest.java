/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richochetrobotsline;

import game.Line;
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
        Line line = new Line();
        line.barriers = new ArrayList<Integer>();
        line.barriers.add(0);
        line.barriers.add(5);
        
        ArrayList<Integer> robots = new ArrayList<>();
        
        Integer result = line.move(robots, 3, true);
        assertEquals(4,result.intValue());
        result = line.move(robots, 4, false);
        assertEquals(0,result.intValue());
        result = line.move(robots, 4, true);
        assertEquals(4,result.intValue());
        result = line.move(robots, 0, false);
        assertEquals(0,result.intValue());
    }
    
}
