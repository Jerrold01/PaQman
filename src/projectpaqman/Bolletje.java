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
        g.drawOval(vakje.getPosX()*25+9, vakje.getPosY()*25+9, 7, 7);
        g.fillOval(vakje.getPosX()*25+9, vakje.getPosY()*25+9, 7, 7);
    }
    
    @Override
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        gameEventListener.gameEventOccurred(new GameEvent(EventType.EATBOLLETJE));
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        if(gameEvent.getEventType().equals(EventType.MOVE)){
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
}
