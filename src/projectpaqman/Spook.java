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
public class Spook extends Spelelement{
    
    BeweegStrategy beweegstrategy;
    
    public Spook(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
        
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.fillRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
    }
    
    public void move(){
        this.beweegstrategy = new BeweegDronken();
        beweegstrategy.move(this, gameEventListener);
    }     
    
}
  
    

