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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author kevinwareman
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({projectpaqman.PaqmanTest.class, projectpaqman.MainFrameTest.class, projectpaqman.SuperbolletjeTest.class, projectpaqman.DrawInterfaceTest.class, projectpaqman.SpelTest.class, projectpaqman.MenuTest.class, projectpaqman.SpelelementTest.class, projectpaqman.VakjeTest.class, projectpaqman.BolletjeTest.class, projectpaqman.LevelTest.class})
public class ProjectpaqmanSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
