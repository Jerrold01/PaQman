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
 * @author kevinwareman
 */
public class PaqmanHelperTest {
    
    public PaqmanHelperTest() {
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
     * Test of draw method, of class PaqmanHelper.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        PaqmanHelper instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameEventOccurred method, of class PaqmanHelper.
     */
    @Test
    public void testGameEventOccurred() {
        System.out.println("gameEventOccurred");
        GameEvent gameEvent = null;
        PaqmanHelper instance = null;
        instance.gameEventOccurred(gameEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
