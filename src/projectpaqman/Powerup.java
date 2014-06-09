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
        g.setColor(Color.MAGENTA);
        g.drawOval(vakje.getPosX()*25+9, vakje.getPosY()*25+9, 7, 7);
        g.fillOval(vakje.getPosX()*25+9, vakje.getPosY()*25+9, 7, 7);
        g.setColor(Color.RED);
        g.drawOval(vakje.getPosX()*25+11, vakje.getPosY()*25+11, 3, 3);
        g.fillOval(vakje.getPosX()*25+11, vakje.getPosY()*25+11, 3, 3);
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
    
    @Override
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        int powerupInt = new Random().nextInt(Powerups.values().length);
        gameEventListener.gameEventOccurred(new GameEvent(Powerups.values()[powerupInt], EventType.POWERUP));
    } 
}
