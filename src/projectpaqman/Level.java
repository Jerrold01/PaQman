/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Jerrold
 */
public class Level extends JPanel{

    private String naam;
    private Vakje[][] vakjes;
    private String[][] layout = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
        {"m", "p", "x", "x", "x", "b", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "x", "m", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "s", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
                                                        
    };
    private EventListenerList listenerList = new EventListenerList();

    /**
     * @param naam De naam van het level.
     * @param lengte De lengte in pixels x van het level.
     * @param breedte  De breedte in pixels y van het level.
     */
    public Level(String naam, int lengte, int breedte) {
        this.setBackground(Color.WHITE);
        this.naam = naam;
        this.vakjes = new Vakje[lengte / 30][breedte / 30];
        this.setFocusable(true);
        this.requestFocus();
        init();
    }
    
    /**
     * De functie die alle vakjes,de bijbehorende elementen en de bijbehorende buren initialiseert.
     * Deze functie voegt tevens een KeyListener toe aan Paqman.
     */
    private void init(){
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                switch(layout[y][x]){
                    case "m":
                        vakjes[x][y] = new Vakje(x, y);
                        vakjes[x][y].setMuur(true);
                        break;
                    case "b": 
                        vakjes[x][y] = new Vakje(x, y);
                        vakjes[x][y].addElement(new Bolletje(vakjes[x][y]));
                        break;
                    case "s":
                        vakjes[x][y] = new Vakje(x, y);
                        vakjes[x][y].addElement(new Superbolletje(vakjes[x][y]));
                        break;
                    case "p":
                        vakjes[x][y] = new Vakje(x, y);
                        Paqman paqman = new Paqman(vakjes[x][y]);
                        vakjes[x][y].addElement(paqman);
                        this.addKeyListener(paqman);
                        this.addGameEventListener(paqman);
                        break;
                    default:
                        vakjes[x][y] = new Vakje(x, y);
                        break;
                }
            }
        }
        setBuren();
    }
    
    /**
     * De functie waarmee alle buren van de vakjes, die binnen de constructor van klasse Level worden aangemaakt, worden meegegeven.
     */
    public void setBuren(){
        for(int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                //Als het vakje niet in de bovenste rij zit.
                if(y != 0){
                    vakjes[x][y].setBuren(Windrichting.NOORD, vakjes[x][y-1]);
                }
                
                //Als het vakje niet in de linkse kolom zit.
                if(x != 0){
                    vakjes[x][y].setBuren(Windrichting.WEST, vakjes[x-1][y]);
                }
                
                //Als het vakje niet in de rechtste kolom zit.
                if (x != vakjes.length-1){
                    vakjes[x][y].setBuren(Windrichting.OOST, vakjes[x+1][y]);
                }
                
                //Als het vakje niet in de onderste rij zit.
                if (y != vakjes[x].length-1) {
                    vakjes[x][y].setBuren(Windrichting.ZUID, vakjes[x][y+1]);
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                vakjes[x][y].draw(g);
            }
        }
    }
    
    public void addGameEventListener(GameEventListener listener) {
        listenerList.add(GameEventListener.class, listener);
    }
    
    public void removeGameEventListener(GameEventListener listener) {
        listenerList.remove(GameEventListener.class, listener);
    }
    
    public void fireGameEvent(GameEvent event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i+2) {
            if (listeners[i] == GameEventListener.class) {
                ((GameEventListener) listeners[i+1]).gameEventOccurred(event);
            }
        }
    }
}
