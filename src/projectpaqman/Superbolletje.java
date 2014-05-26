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
public class Superbolletje extends Spelelement {
    
    public Superbolletje(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.drawOval(vakje.getPosX()*30+8, vakje.getPosY()*30+8, 16, 16);
        g.fillOval(vakje.getPosX()*30+8, vakje.getPosY()*30+8, 16, 16);
    }
}
