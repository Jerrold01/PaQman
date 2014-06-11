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
public abstract class Spelelement implements GameEventListener{
    
    protected Vakje vakje;
    protected GameEventListener gameEventListener;
    
    public Spelelement(Vakje vakje, GameEventListener gameEventListener){
        this.vakje = vakje;
        this.gameEventListener = gameEventListener;
    }
    
    public void setVakje(Vakje vakje){
        this.vakje = vakje;
    }
    
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        gameEventListener = null;
    }
    
    protected void respawn(){}
    
    protected abstract void draw(Graphics g);
}
