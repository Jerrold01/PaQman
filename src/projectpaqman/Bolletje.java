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
public class Bolletje extends Spelelement {
    
    public Bolletje(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(vakje.getPosX()*30, vakje.getPosY()*30, 30, 30);
        g.fillOval(vakje.getPosX()*30, vakje.getPosY()*30, 30, 30);
    }
}
