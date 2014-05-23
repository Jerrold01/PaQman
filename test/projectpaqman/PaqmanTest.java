/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
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
public class PaqmanTest {
    
    public PaqmanTest() {
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
     * Test of draw method, of class Paqman.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Paqman instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class Paqman.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent event = null;
        Paqman instance = null;
        instance.keyReleased(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class Paqman.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent event = null;
        Paqman instance = null;
        instance.keyPressed(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyTyped method, of class Paqman.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent event = null;
        Paqman instance = null;
        instance.keyTyped(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
