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
    
    public enum inhoudVakje{
        bolletje,
        superbolletje,
        muur,
        leeg
    }
    
    public Vakje(Graphics g, int posX, int posY, inhoudVakje inhoudVakje) {
        this.posX = posX;
        this.posY = posY;
        draw(g, inhoudVakje);
    }
    

    
    public void draw(Graphics g, inhoudVakje inhoudVakje) {
        g.setColor(Color.BLACK);
        switch (inhoudVakje){
            case bolletje:
                g.drawRect(posX, posY, 30, 30);
                Bolletje b = new Bolletje();
                b.draw(g, posX, posY);
                break;
            case superbolletje:
                g.drawRect(posX, posY, 30, 30);
                Superbolletje s = new Superbolletje();
                s.draw(g, posX, posY);
                break;
            case muur:
                g.drawRect(posX, posY, 30, 30);
                g.fillRect(posX, posX, 30, 30);
                break;
            case leeg:
                g.drawRect(posX, posY, 30, 30);
                break;
                
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
