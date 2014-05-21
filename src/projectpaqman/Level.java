/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.lang.reflect.Array;
import javax.swing.JPanel;

/**
 *
 * @author Jerrold
 */
public class Level extends JPanel{

    private String naam;
    private int lengte;
    private int breedte;
    private Vakje[][] vakjes;
    private Array[][] layout;
    
    public Level(String naam, int lengte, int breedte){
        this.setBackground(Color.WHITE);
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.vakjes = new Vakje[lengte/30][breedte/30];
        
        
        
        for(int x = 0; x < vakjes.length; x++){
            for(int y = 0; y < vakjes[x].length; y++){
                vakjes[x][y] = new Vakje(true, x*30, y*30);
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        for(int x=0; x < vakjes.length; x++) {
            for(int y=0; y < vakjes[x].length; y++) {
                vakjes[x][y].draw(g);
            }
        }
    }
}
