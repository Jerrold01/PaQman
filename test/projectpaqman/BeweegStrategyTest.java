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
 * @author Jerrold
 */
public class BeweegStrategyTest {
    
    public BeweegStrategyTest() {
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
     * Test of move method, of class BeweegStrategy.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Spelelement spelelement = null;
        GameEventListener gameEventListener = null;
        BeweegStrategy instance = new BeweegStrategyImpl();
        instance.move(spelelement, gameEventListener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BeweegStrategyImpl implements BeweegStrategy {

        public void move(Spelelement spelelement, GameEventListener gameEventListener) {
        }
    }
    
}
