/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevinwareman
 */
public class GameEventTest {
    
    public GameEventTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSource method, of class GameEvent.
     */
    @Test
    public void testGetSource() {
        System.out.println("getSource");
        GameEvent instance = null;
        Object expResult = null;
        Object result = instance.getSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowerup method, of class GameEvent.
     */
    @Test
    public void testGetPowerup() {
        System.out.println("getPowerup");
        GameEvent instance = null;
        Powerups expResult = null;
        Powerups result = instance.getPowerup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventType method, of class GameEvent.
     */
    @Test
    public void testGetEventType() {
        System.out.println("getEventType");
        GameEvent instance = null;
        EventType expResult = null;
        EventType result = instance.getEventType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
