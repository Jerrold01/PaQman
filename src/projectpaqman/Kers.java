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
        g.setColor(Color.GREEN);
        g.fillOval(vakje.getPosX()*25+6, vakje.getPosY()*25, 11, 11);
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25+6, vakje.getPosY()*25, 11, 11);
        
        g.setColor(Color.RED);
        g.fillOval(vakje.getPosX()*25, vakje.getPosY()*25+12, 11, 11 );
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25, vakje.getPosY()*25+12, 11, 11);        
        g.fillOval(vakje.getPosX()*25+12, vakje.getPosY()*25+12, 11, 11);
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25+12, vakje.getPosY()*25+12, 11, 11);
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case MOVE:
                if(vakje != null){
                    for(Spelelement element : vakje.getElementen()){
                        if(element instanceof Paqman){
                            delete();
                            break;
                        }
                    }
                }
                break;
        }
    }
    
    @Override
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        gameEventListener.gameEventOccurred(new GameEvent(EventType.EATKERS));
    }
}
