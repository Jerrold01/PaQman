/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.util.Random;

/**
 *
 * @author kevinwareman
 */
public class Powerup extends Spelelement {
    
    public Powerup(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(vakje.getPosX()*25+12, vakje.getPosY()*25+8, 5, 4);
        g.fillRect(vakje.getPosX()*25+8, vakje.getPosY()*25+12, 13, 5);
        g.fillRect(vakje.getPosX()*25+12, vakje.getPosY()*25+17, 5, 4);
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
        int powerupInt = new Random().nextInt(Powerups.values().length);
        gameEventListener.gameEventOccurred(new GameEvent(Powerups.values()[powerupInt], GameEventType.POWERUP));
    } 
}
