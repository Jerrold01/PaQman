/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jerrold
 */
public class Level extends JPanel implements GameEventListener{

    private String naam;
    private Vakje[][] vakjes;
    private String[][] layout = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
        {"m", "p", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "m", "m", "m", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "b", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m", "x", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "m", "m", "m", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m", "x", "b", "b", "m", "b", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "m", "m", "m", "m", "m", "m", "b", "m", "b", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "b", "b", "b", "b", "b", "m", "b", "m", "b", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "m", "m", "x", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "b", "m", "x", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "x", "x", "b", "b", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "b", "m", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "b", "b", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "m", "x", "x", "x", "x", "x", "m", "x", "x", "b", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "m", "m", "x", "m", "m", "x", "x", "m", "x", "x", "b", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "x", "b", "b", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "m", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "b", "b", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "b", "b", "x", "m", "x", "b", "x", "m", "m", "x", "x", "m", "m", "b", "m", "x", "x", "x", "m", "m", "m", "m", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "m", "b", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "m", "b", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "m", "m", "m", "m", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "m", "b", "b", "b", "b", "b", "m", "x", "m", "m", "m", "m", "m", "x", "x", "x", "b", "b", "b", "b", "b", "m", "x", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "m", "m", "m", "m", "m", "x", "m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "m", "m", "m", "m", "m", "m", "x", "x", "m"},
        {"m", "x", "m", "m", "x", "x", "m", "x", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "x", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "b", "b", "b", "x", "m", "x", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "m"},
        {"m", "x", "b", "b", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "m"},
        {"m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"}                                             
    };

    /**
     * @param naam De naam van het level.
     * @param lengte De lengte in pixels x van het level.
     * @param breedte  De breedte in pixels y van het level.
     */
    public Level(String naam, int lengte, int breedte) {
        this.setBackground(Color.WHITE);
        this.naam = naam;
        this.vakjes = new Vakje[lengte / 25][breedte / 25];
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
                        vakjes[x][y].addElement(new Bolletje(vakjes[x][y], this));
                        break;
                    case "s":
                        vakjes[x][y] = new Vakje(x, y);
                        vakjes[x][y].addElement(new Superbolletje(vakjes[x][y], this));
                        break;
                    case "p":
                        vakjes[x][y] = new Vakje(x, y);
                        Paqman paqman = new Paqman(vakjes[x][y], this);
                        vakjes[x][y].addElement(paqman);
                        this.addKeyListener(paqman);
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
        super.paintComponent(g);
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                vakjes[x][y].draw(g);
            }
        }
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        repaint();
    }
}
