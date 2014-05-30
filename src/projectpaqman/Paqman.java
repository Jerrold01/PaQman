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
    
    Vakje startVakje;
    
    public Paqman(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
        this.startVakje = vakje;
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
        g.drawOval(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.fillOval(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
    }

    @Override
    public void keyReleased(KeyEvent event){
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
        gameEventListener.gameEventOccurred(new GameEvent(EventType.MOVE));
    }
    
    public void respawn(){
        vakje.removeElement(this);
        startVakje.addElement(this);
        vakje = startVakje;
        gameEventListener.gameEventOccurred(new GameEvent(EventType.DEAD));
    }

    @Override
    public void keyPressed(KeyEvent event){

    }
    
    @Override
    public void keyTyped(KeyEvent event){

    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        if(gameEvent.getEventType().equals(EventType.MOVE)){
            if(vakje != null){
                   for(Spelelement element : vakje.getElementen()){
                    if(element instanceof Spook){
                        respawn();
                        break;
                    }
                }  
            }
        }
    }
}
