/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jerrold
 */
public class LevelTest {
    
    public LevelTest() {
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
     * Test of paintComponent method, of class Level.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Level instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBuren method, of class Level.
     */
    @Test
    public void testSetBuren() {
        System.out.println("setBuren");
        Level instance = null;
        instance.setBuren();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGameEventListener method, of class Level.
     */
    @Test
    public void testAddGameEventListener() {
        System.out.println("addGameEventListener");
        GameEventListener listener = null;
        Level instance = null;
        instance.addGameEventListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeGameEventListener method, of class Level.
     */
    @Test
    public void testRemoveGameEventListener() {
        System.out.println("removeGameEventListener");
        GameEventListener listener = null;
        Level instance = null;
        instance.removeGameEventListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fireGameEvent method, of class Level.
     */
    @Test
    public void testFireGameEvent() {
        System.out.println("fireGameEvent");
        GameEvent event = null;
        Level instance = null;
        instance.fireGameEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameEventOccurred method, of class Level.
     */
    @Test
    public void testGameEventOccurred() {
        System.out.println("gameEventOccurred");
        GameEvent event = null;
        Level instance = null;
        instance.gameEventOccurred(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
