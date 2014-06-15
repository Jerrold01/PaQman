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
        g.drawOval(vakje.getPosX()*25+5, vakje.getPosY()*25+5, 15, 15);
        g.fillOval(vakje.getPosX()*25+5, vakje.getPosY()*25+5, 15, 15);
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25+5, vakje.getPosY()*25+5, 15, 15);
    }
    
    @Override
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        gameEventListener.gameEventOccurred(new GameEvent(GameEventType.EATSUPERBOLLETJE));
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
