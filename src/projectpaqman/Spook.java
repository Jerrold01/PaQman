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
public class Spook extends Spelelement implements GameEventListener{
    
    BeweegStrategy beweegstrategy;
    
    public Spook(Vakje vakje, GameEventListener gameEventListener, BeweegStrategy beweegStrategy){
        super(vakje, gameEventListener);
        this.beweegstrategy = beweegStrategy;
    }
    
    private void move(){
        beweegstrategy.move(this, gameEventListener);
    } 
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.fillRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
    }    
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        if(gameEvent.getEventType().equals(EventType.TIMER)){
            move();            
        }
    }
}
  
    

