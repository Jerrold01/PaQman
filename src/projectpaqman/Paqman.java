/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Jerrold
 */
public class Paqman extends Spelelement implements KeyListener {
    
    public Paqman(Vakje vakje){
        super(vakje);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawOval(vakje.getPosX()*30, vakje.getPosY()*30, 30, 30);
        g.fillOval(vakje.getPosX()*30, vakje.getPosY()*30, 30, 30);
    }

    @Override
    public void keyReleased(KeyEvent event){

    }
    
    @Override
    public void keyPressed(KeyEvent event){
        switch(event.getKeyCode()){
            case KeyEvent.VK_UP: 
                System.out.println("Loop omhoog");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Loop omlaag");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Loop links");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Loop rechts");
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent event){
        
    }
}
