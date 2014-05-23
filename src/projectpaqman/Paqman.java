/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 *
 * @author Jerrold
 */
public class Paqman extends Spelelement implements KeyListener {
       
    public Paqman(Vakje vakje){
        super(vakje);
    }
    
    private void move(Windrichting windrichting){
        HashMap<Windrichting, Vakje> buren = vakje.getBuren();
        Vakje nieuwVakje = buren.get(windrichting);
        if(!nieuwVakje.getMuur()){
            nieuwVakje.addElement(this);
            vakje.removeElement(this);
            vakje = nieuwVakje;
        }
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
                this.move(Windrichting.NOORD);
                break;
            case KeyEvent.VK_DOWN:
                this.move(Windrichting.ZUID);
                break;
            case KeyEvent.VK_LEFT:
                this.move(Windrichting.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                this.move(Windrichting.OOST);
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent event){
        
    }
}
