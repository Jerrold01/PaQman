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


/**
 *
 * @author Jerrold
 */
public class BeweegSlimTest {

    
    public BeweegSlimTest() {
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

//    @Test
//    public void testNextVakje() {
//        //Test eerste fysieke testgeval
//        Level testlevel_1 = new Level(5, new GameEventHandler());
//        Spook spook = null;
//        
//        for(Spelelement element : testlevel_1.getVakje(1, 1).getElementen()){
//            if(element instanceof Spook){
//                spook = (Spook)element;
//            }
//        }
//        
//        spook.gameEventOccurred(new GameEvent(GameEventType.TIMER));
//        assert(spook.vakje.equals(testlevel_1.getVakje(1, 2)));
//        
//        
//        //Test tweede fysieke testgeval
//        Level testlevel_2 = new Level(6, new GameEventHandler());
//        spook = null;
//        
//        for(Spelelement element : testlevel_2.getVakje(1, 3).getElementen()){
//            if(element instanceof Spook){
//                spook = (Spook)element;
//            }
//        }
//        
//        spook.gameEventOccurred(new GameEvent(GameEventType.TIMER));
//        assert(spook.vakje.equals(testlevel_2.getVakje(1, 2)));
//    }
    
    @Test
    public void onderzoeksTest(){
        Level testlevel_1 = new Level(4, new GameEventHandler());
        Spook spook = null;
        
        for(Spelelement element : testlevel_1.getVakje(3, 3).getElementen()){
            if(element instanceof Spook){
                spook = (Spook)element;
            }
        }
        spook.gameEventOccurred(new GameEvent(GameEventType.TIMER));
    }
}
