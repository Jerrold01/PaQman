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
public abstract class Spelelement implements DrawInterface {
    
    private Vakje vakje;
    
    public Spelelement(Vakje vakje){
        this.vakje = vakje;
    }
    
    public void setVakje(Vakje vakje){
        this.vakje = vakje;
    }
    
    @Override
    public void draw(Graphics g, Vakje vakje){
        if(this instanceof Bolletje){
            this.draw(g, vakje);
        }else if(this instanceof Superbolletje){
            this.draw(g, vakje);
        }else if(this instanceof Paqman){
            this.draw(g, vakje);
        }
    }
}
