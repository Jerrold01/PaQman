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
public class SpelelementTest {
    
    public SpelelementTest() {
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
     * Test of setVakje method, of class Spelelement.
     */
    @Test
    public void testSetVakje() {
        System.out.println("setVakje");
        Vakje vakje = null;
        Spelelement instance = null;
        instance.setVakje(vakje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Spelelement.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Spelelement instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class SpelelementImpl extends Spelelement {

        public SpelelementImpl() {
            super(null);
        }

        public void draw(Graphics g) {
        }
    }

    /**
     * Test of delete method, of class Spelelement.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Spelelement instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of respawn method, of class Spelelement.
     */
    @Test
    public void testRespawn() {
        System.out.println("respawn");
        Spelelement instance = null;
        instance.respawn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
