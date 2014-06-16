/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
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

    }

    /**
     * Test of setBuren method, of class Level.
     */
    @Test
    public void testSetBuren() {
        Level level = new Level(4, new GameEventHandler());
        
        Vakje vakje_1 = level.getVakje(0, 0);
        assert(vakje_1.getBuren().get(Windrichting.NOORD) == null && vakje_1.getBuren().get(Windrichting.WEST) == null && vakje_1.getBuren().get(Windrichting.ZUID).equals(level.getVakje(0, 1)) && vakje_1.getBuren().get(Windrichting.OOST).equals(level.getVakje(1, 0)));
        
        Vakje vakje_2 = level.getVakje(0, 3);
        assert(vakje_2.getBuren().get(Windrichting.NOORD).equals(level.getVakje(0, 2)) && vakje_2.getBuren().get(Windrichting.WEST) == null && vakje_2.getBuren().get(Windrichting.ZUID).equals(level.getVakje(0, 4)) && vakje_2.getBuren().get(Windrichting.OOST).equals(level.getVakje(1, 3)));
        
        Vakje vakje_3 = level.getVakje(0, 4);
        assert(vakje_3.getBuren().get(Windrichting.NOORD).equals(level.getVakje(0, 3)) && vakje_3.getBuren().get(Windrichting.WEST) == null && vakje_3.getBuren().get(Windrichting.ZUID) == null && vakje_3.getBuren().get(Windrichting.OOST).equals(level.getVakje(1, 4)));
        
        Vakje vakje_4 = level.getVakje(3, 0);
        assert(vakje_4.getBuren().get(Windrichting.NOORD) == null && vakje_4.getBuren().get(Windrichting.WEST).equals(level.getVakje(2,0)) && vakje_4.getBuren().get(Windrichting.ZUID).equals(level.getVakje(3, 1)) && vakje_4.getBuren().get(Windrichting.OOST).equals(level.getVakje(4, 0)));
        
        Vakje vakje_5 = level.getVakje(3, 3);
        assert(vakje_5.getBuren().get(Windrichting.NOORD).equals(level.getVakje(3, 2)) && vakje_5.getBuren().get(Windrichting.WEST).equals(level.getVakje(2, 3)) && vakje_5.getBuren().get(Windrichting.ZUID).equals(level.getVakje(3, 4)) && vakje_5.getBuren().get(Windrichting.OOST).equals(level.getVakje(4, 3)));
        
        Vakje vakje_6 = level.getVakje(3, 4);
        assert(vakje_6.getBuren().get(Windrichting.NOORD).equals(level.getVakje(3, 3)) && vakje_6.getBuren().get(Windrichting.WEST).equals(level.getVakje(2, 4)) && vakje_6.getBuren().get(Windrichting.ZUID) == null && vakje_6.getBuren().get(Windrichting.OOST).equals(level.getVakje(4, 4)));
        
        Vakje vakje_7 = level.getVakje(4, 0);
        assert(vakje_7.getBuren().get(Windrichting.NOORD) == null && vakje_7.getBuren().get(Windrichting.WEST).equals(level.getVakje(3, 0)) && vakje_7.getBuren().get(Windrichting.ZUID).equals(level.getVakje(4, 1)) && vakje_7.getBuren().get(Windrichting.OOST) == null);
        
        Vakje vakje_8 = level.getVakje(4, 3);
        assert(vakje_8.getBuren().get(Windrichting.NOORD).equals(level.getVakje(4, 2)) && vakje_8.getBuren().get(Windrichting.WEST).equals(level.getVakje(3, 3)) && vakje_8.getBuren().get(Windrichting.ZUID).equals(level.getVakje(4, 4)) && vakje_8.getBuren().get(Windrichting.OOST) == null);
       
        Vakje vakje_9 = level.getVakje(4, 4);
        assert(vakje_9.getBuren().get(Windrichting.NOORD).equals(level.getVakje(4, 3)) && vakje_9.getBuren().get(Windrichting.WEST).equals(level.getVakje(3, 4)) && vakje_9.getBuren().get(Windrichting.ZUID) == null && vakje_9.getBuren().get(Windrichting.OOST) == null);
    }

    /**
     * Test of addGameEventListener method, of class Level.
     */
    @Test
    public void testAddGameEventListener() {

    }

    /**
     * Test of removeGameEventListener method, of class Level.
     */
    @Test
    public void testRemoveGameEventListener() {

    }

    /**
     * Test of gameEventOccurred method, of class Level.
     */
    @Test
    public void testGameEventOccurred() {

    }

    /**
     * Test of getLevel method, of class Level.
     */
    @Test
    public void testGetLevel() {

    }

    /**
     * Test of getGameText method, of class Level.
     */
    @Test
    public void testGetGameText() {

    }

    /**
     * Test of setGameText method, of class Level.
     */
    @Test
    public void testSetGameText() {

    }

    /**
     * Test of spawnPowerup method, of class Level.
     */
    @Test
    public void testSpawnPowerup() {

    }

    /**
     * Test of delete method, of class Level.
     */
    @Test
    public void testDelete() {

    }

    /**
     * Test of actionPerformed method, of class Level.
     */
    @Test
    public void testActionPerformed() {

    }

    /**
     * Test of getLevelText method, of class Level.
     */
    @Test
    public void testGetLevelText() {
    }

    /**
     * Test of setLevelText method, of class Level.
     */
    @Test
    public void testSetLevelText() {
    }

    /**
     * Test of getVakje method, of class Level.
     */
    @Test
    public void testGetVakje() {
    }

    /**
     * Test of spawnPaqmanHelper method, of class Level.
     */
    @Test
    public void testSpawnPaqmanHelper() {
    }
}
