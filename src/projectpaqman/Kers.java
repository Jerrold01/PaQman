/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;

/**
 *
 * @author Kevin
 */
public class Kers extends Spelelement {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public Kers(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(vakje.getPosX()*25+9, vakje.getPosY()*25+9, 7, 7);
        g.fillOval(vakje.getPosX()*25+9, vakje.getPosY()*25+9, 8, 8);
    }
    
    @Override
    public void gameEventOccurred(GameEvent event){
        if(vakje != null){
            for(Spelelement element : vakje.getElementen()){
                if(element instanceof Paqman){
                    delete();
                    break;
                }
            }  
        }
    }
}
