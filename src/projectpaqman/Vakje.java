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
public class Vakje {
    
    private boolean muur;
    private int posX;
    private int posY;
    private Spelelement elt;
    
    public Vakje(boolean muur, int posX, int posY) {
        this.muur = muur;
        this.posX = posX;
        this.posY = posY;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, 30, 30);
        if (elt!=null){
            //elt.draw(x,y,g);
        }
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public void setMuur(boolean muur){
        this.muur = muur;
    }
}
