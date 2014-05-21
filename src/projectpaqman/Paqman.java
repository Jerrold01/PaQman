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
public class Paqman extends Spelelement {
    
    public Paqman(Vakje vakje){
        super(vakje);
    }
        
    @Override
    public void draw(Graphics g, Vakje vakje) {
        g.setColor(Color.YELLOW);
        g.drawOval(vakje.getPosX()*30, vakje.getPosY()*30, 30, 30);
        g.fillOval(vakje.getPosX()*30, vakje.getPosY()*30, 30, 30);
    }
}
