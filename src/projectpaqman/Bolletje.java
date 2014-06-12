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
        g.fillOval(vakje.getPosX()*25+10, vakje.getPosY()*25+10, 5, 5);
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25+10, vakje.getPosY()*25+10, 5, 5);
    }
    
    @Override
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        gameEventListener.gameEventOccurred(new GameEvent(EventType.EATBOLLETJE));
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
}
