/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jerrold
 */
public class Level extends JPanel implements KeyListener {

    private String naam;
    private Vakje[][] vakjes;
    private String[][] layout = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
        {"m", "p", "x", "x", "x", "b", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "x", "m", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "s", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"}
    };

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
    }
    
    /**
     * De functie waarmee alle buren van de vakjes, die binnen de constructor van klasse Level worden aangemaakt, worden meegegeven.
     */
    private void setBuren(){
        for(int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                //Als het vakje op 0,0 zit: Voeg buren in OOST en ZUID toe.
                if(x == 0 && y == 0){
                    vakjes[x][y].setBuren("OOST", vakjes[x+1][y]);
                    vakjes[x][y].setBuren("ZUID", vakjes[x][y+1]);
                //Als het vakje op 0,MAX zit: Voeg buren in OOST en NOORD toe.
                } else if (x == 0 && y == vakjes[x].length-1){
                    vakjes[x][y].setBuren("OOST", vakjes[x+1][y]);
                    vakjes[x][y].setBuren("NOORD", vakjes[x][y-1]);
                //ALS het vakje op MAX, 0 zit: Voeg buren in ZUID en WEST toe.
                } else if (x == vakjes.length-1 && y == 0){
                    vakjes[x][y].setBuren("ZUID", vakjes[x][y+1]);
                    vakjes[x][y].setBuren("WEST", vakjes[x-1][y]);
                //ALS het vakje op MAX, MAX zit: Voeg buren in NOORD en WEST toe.
                } else if (x == vakjes.length-1 && y == vakjes[x].length-1){
                    vakjes[x][y].setBuren("NOORD", vakjes[x][y-1]);
                    vakjes[x][y].setBuren("WEST", vakjes[x-1][y]);
                //ALS het vakje op 0,X zit: Voeg buren NOORD en ZUID en OOST toe.
                } else if (x == 0){
                    vakjes[x][y].setBuren("NOORD", vakjes[x][y-1]);
                    vakjes[x][y].setBuren("ZUID", vakjes[x][y+1]);
                    vakjes[x][y].setBuren("OOST", vakjes[x+1][y]);
                //ALS het vakje op MAX,X Zit: Voeg buren NOORD en ZUID en WEST toe.
                } else if (x == vakjes.length-1){
                    vakjes[x][y].setBuren("NOORD", vakjes[x][y-1]);
                    vakjes[x][y].setBuren("ZUID", vakjes[x][y+1]);
                    vakjes[x][y].setBuren("WEST", vakjes[x-1][y]);
                //ALS het vakje op X,0 zit: Voeg buren WEST en OOST en ZUID toe.
                } else if (y == 0){
                    vakjes[x][y].setBuren("WEST", vakjes[x-1][y]);
                    vakjes[x][y].setBuren("OOST", vakjes[x+1][y]);
                    vakjes[x][y].setBuren("ZUID", vakjes[x][y+1]);
                //ALS het vakje op X,MAX zit: Voeg buren WEST en OOST en NOORD toe.
                } else if (y == vakjes[x].length-1){
                    vakjes[x][y].setBuren("WEST", vakjes[x-1][y]);
                    vakjes[x][y].setBuren("OOST", vakjes[x+1][y]);
                    vakjes[x][y].setBuren("NOORD", vakjes[x][y-1]);
                //In alle andere gevallen: Voeg buren NOORD, ZUID, OOST, WEST toe.
                } else {
                    vakjes[x][y].setBuren("NOORD", vakjes[x][y-1]);
                    vakjes[x][y].setBuren("ZUID", vakjes[x][y+1]);
                    vakjes[x][y].setBuren("WEST", vakjes[x-1][y]);
                    vakjes[x][y].setBuren("OOST", vakjes[x+1][y]);
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                System.out.println(x + " " + y + " " + layout[y][x]);
                vakjes[x][y] = new Vakje(g, x , y , layout[y][x]);
            }
        }
        this.requestFocus();
        setBuren();
    }
    
    @Override
    public void keyReleased(KeyEvent event){

    }
    
    @Override
    public void keyPressed(KeyEvent event){
        switch(event.getKeyCode()){
            case KeyEvent.VK_UP: 
                System.out.println("Loop omhoog");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Loop omlaag");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Loop links");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Loop rechts");
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent event){
        
    }
}
