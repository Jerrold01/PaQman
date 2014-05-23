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
public class GameEventListenerTest {
    
    public GameEventListenerTest() {
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
     * Test of addGameEventListener method, of class GameEventListener.
     */
    @Test
    public void testAddGameEventListener() {
        System.out.println("addGameEventListener");
        GameEventListener listener = null;
        GameEventListener instance = new GameEventListenerImpl();
        instance.addGameEventListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeGameEventListener method, of class GameEventListener.
     */
    @Test
    public void testRemoveGameEventListener() {
        System.out.println("removeGameEventListener");
        GameEventListener listener = null;
        GameEventListener instance = new GameEventListenerImpl();
        instance.removeGameEventListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fireGameEvent method, of class GameEventListener.
     */
    @Test
    public void testFireGameEvent() {
        System.out.println("fireGameEvent");
        GameEvent event = null;
        GameEventListener instance = new GameEventListenerImpl();
        instance.fireGameEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameEventOccurred method, of class GameEventListener.
     */
    @Test
    public void testGameEventOccurred() {
        System.out.println("gameEventOccurred");
        GameEvent event = null;
        GameEventListener instance = new GameEventListenerImpl();
        instance.gameEventOccurred(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GameEventListenerImpl implements GameEventListener {

        public void addGameEventListener(GameEventListener listener) {
        }

        public void removeGameEventListener(GameEventListener listener) {
        }

        public void fireGameEvent(GameEvent event) {
        }

        public void gameEventOccurred(GameEvent event) {
        }
    }
    
}
