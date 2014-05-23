/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;

/**
 *
 * @author Jerrold
 */
public abstract class Spelelement {
    
    protected Vakje vakje;
    
    public Spelelement(Vakje vakje){
        this.vakje = vakje;
    }
    
    public void setVakje(Vakje vakje){
        this.vakje = vakje;
    }
    
    public abstract void draw(Graphics g);
}
