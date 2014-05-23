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
public class GameTest {
    
    public GameTest() {
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
     * Test of getAantalLevens method, of class Game.
     */
    @Test
    public void testGetAantalLevens() {
        System.out.println("getAantalLevens");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getAantalLevens();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAantalLevens method, of class Game.
     */
    @Test
    public void testSetAantalLevens() {
        System.out.println("setAantalLevens");
        int aantal_levens = 0;
        Game instance = new Game();
        instance.setAantalLevens(aantal_levens);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAantalPunten method, of class Game.
     */
    @Test
    public void testGetAantalPunten() {
        System.out.println("getAantalPunten");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getAantalPunten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAantalPunten method, of class Game.
     */
    @Test
    public void testSetAantalPunten() {
        System.out.println("setAantalPunten");
        int aantal_punten = 0;
        Game instance = new Game();
        instance.setAantalPunten(aantal_punten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnverslaanbaar method, of class Game.
     */
    @Test
    public void testGetOnverslaanbaar() {
        System.out.println("getOnverslaanbaar");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.getOnverslaanbaar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOnverslaanbaar method, of class Game.
     */
    @Test
    public void testSetOnverslaanbaar() {
        System.out.println("setOnverslaanbaar");
        boolean onverslaanbaar = false;
        Game instance = new Game();
        instance.setOnverslaanbaar(onverslaanbaar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGepauzeerd method, of class Game.
     */
    @Test
    public void testGetGepauzeerd() {
        System.out.println("getGepauzeerd");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.getGepauzeerd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGepauzeerd method, of class Game.
     */
    @Test
    public void testSetGepauzeerd() {
        System.out.println("setGepauzeerd");
        boolean gepauzeerd = false;
        Game instance = new Game();
        instance.setGepauzeerd(gepauzeerd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
