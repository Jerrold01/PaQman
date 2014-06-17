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
    
    /**
     * De methode die een spelelement op een nieuw vakje zet.
     * @param vakje Het nieuwe vakje van een spelelement.
     */
    public void setVakje(Vakje vakje){
        this.vakje = vakje;
    }
    
    /**
     * De methode die een spelement kan implementeren mocht deze zichzelf moeten deleten.
     */
    protected void delete(){
        vakje.removeElement(this);
        setVakje(null);
        gameEventListener = null;
    }
    
    /**
     * De methode die een spelelement kan implementeren mocht deze kunnen respawnen.
     */
    protected void respawn(){}
    
    /**
     * De methode die elk spelement heeft en waarmee elke spelelement op zijn eigen manier wordt getekend.
     * @param g Het graphics object.
     */
    protected abstract void draw(Graphics g);
}
