/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
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
        Vakje vakje = new Vakje(0,0);
        Vakje oosterBuur = new Vakje(0,1);
        
        Windrichting windrichting = Windrichting.OOST;
        vakje.setBuren(windrichting, vakje);

        assertEquals(vakje.getBuren().get(windrichting), oosterBuur);
    }

    /**
     * Test of setMuur method, of class Vakje.
     */
    @Test
    public void testSetMuur() {
        System.out.println("setMuur");
        Vakje instance = new Vakje(0,0);
        instance.setMuur(true);
       
        assertTrue(instance.getMuur() == true);
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

    /**
     * Test of removeElement method, of class Vakje.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Spelelement element = null;
        Vakje instance = null;
        instance.removeElement(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuren method, of class Vakje.
     */
    @Test
    public void testGetBuren() {
        System.out.println("getBuren");
        Vakje instance = null;
        HashMap<Windrichting, Vakje> expResult = null;
        HashMap<Windrichting, Vakje> result = instance.getBuren();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMuur method, of class Vakje.
     */
    @Test
    public void testGetMuur() {
        System.out.println("getMuur");
        Vakje instance = null;
        boolean expResult = false;
        boolean result = instance.getMuur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementen method, of class Vakje.
     */
    @Test
    public void testGetElementen() {
        System.out.println("getElementen");
        Vakje instance = null;
        ArrayList<Spelelement> expResult = null;
        ArrayList<Spelelement> result = instance.getElementen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransparent method, of class Vakje.
     */
    @Test
    public void testGetTransparent() {
        System.out.println("getTransparent");
        Vakje instance = null;
        boolean expResult = false;
        boolean result = instance.getTransparent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransparent method, of class Vakje.
     */
    @Test
    public void testSetTransparent() {
        System.out.println("setTransparent");
        boolean transparant = false;
        Vakje instance = null;
        instance.setTransparent(transparant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
