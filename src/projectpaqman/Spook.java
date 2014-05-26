/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.*;

/**
 *
 * @author Jerrold
 */
public class Spook extends Spelelement implements KeyListener {
    
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
        beweegstrategy.move(vakje.getBuren(), vakje, this, gameEventListener);
    }
    
    
    @Override
    public void keyReleased(KeyEvent event){

    }
    
    @Override
    public void keyPressed(KeyEvent event){
        move();
    }
    
    
    @Override
    public void keyTyped(KeyEvent event){
        
    }
        
}
  
    

