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
public class DrawInterfaceTest {
    
    public DrawInterfaceTest() {
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
     * Test of draw method, of class DrawInterface.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Vakje vakje = null;
        DrawInterface instance = new DrawInterfaceImpl();
        instance.draw(g, vakje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DrawInterfaceImpl implements DrawInterface {

        public void draw(Graphics g, Vakje vakje) {
        }
    }
    
}
