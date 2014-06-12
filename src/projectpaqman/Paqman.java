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
    boolean gestart;
    boolean gepauzeerd;
    
    public Paqman(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
        this.startVakje = vakje;
        this.gestart = false;
        this.gepauzeerd = false;
    }
    
    private void move(Windrichting windrichting){
        if(gestart && !gepauzeerd){
            HashMap<Windrichting, Vakje> buren = vakje.getBuren();
            Vakje nieuwVakje = buren.get(windrichting);
            if(!nieuwVakje.getMuur() || nieuwVakje.getTransparent()){
                nieuwVakje.addElement(this);
                vakje.removeElement(this);
                vakje = nieuwVakje;
            }
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.setColor(Color.BLACK);
        g.drawOval(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
    }
    
    @Override
    protected void respawn(){
        vakje.removeElement(this);
        startVakje.addElement(this);
        vakje = startVakje;
    }

    @Override
    public void keyPressed(KeyEvent event){

    }
    
    @Override
    public void keyTyped(KeyEvent event){

    }
    
    @Override
    public void keyReleased(KeyEvent event){
            switch(event.getKeyCode()){
            case KeyEvent.VK_UP: 
                this.move(Windrichting.NOORD);
                gameEventListener.gameEventOccurred(new GameEvent(EventType.MOVE));
                break;
            case KeyEvent.VK_DOWN:
                this.move(Windrichting.ZUID);
                gameEventListener.gameEventOccurred(new GameEvent(EventType.MOVE));
                break;
            case KeyEvent.VK_LEFT:
                this.move(Windrichting.WEST);
                gameEventListener.gameEventOccurred(new GameEvent(EventType.MOVE));
                break;
            case KeyEvent.VK_RIGHT:
                this.move(Windrichting.OOST);
                gameEventListener.gameEventOccurred(new GameEvent(EventType.MOVE));
                break;
        }
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){ 
            case DEAD:
                respawn();
                break;
            case START:
                gestart = true;
                gepauzeerd = false;
                break;
            case PAUZEER:
                gepauzeerd = true;
                break;
        }
    }
}
