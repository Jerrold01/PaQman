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
public class VakjeTest {
    
    public VakjeTest() {
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
     * Test of getPosX method, of class Vakje.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        Vakje instance = null;
        int expResult = 0;
        int result = instance.getPosX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosY method, of class Vakje.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        Vakje instance = null;
        int expResult = 0;
        int result = instance.getPosY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addElement method, of class Vakje.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        Spelelement element = null;
        Vakje instance = null;
        instance.addElement(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBuren method, of class Vakje.
     */
    @Test
    public void testSetBuren() {
        System.out.println("setBuren");
        String windrichting = "";
        Vakje vakje = null;
        Vakje instance = null;
        instance.setBuren(windrichting, vakje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMuur method, of class Vakje.
     */
    @Test
    public void testSetMuur() {
        System.out.println("setMuur");
        boolean muur = false;
        Vakje instance = null;
        instance.setMuur(muur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Vakje.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Vakje instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
