/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;


/**
 *
 * @author kevinwareman
 */
public interface BeweegStrategy {
   
    /**
     * De methode welke door alle spoken gebruikt wordt om te bewegen. 
     * @param spelelement Het spelement welke moet bewegen
     */
    public void move(Spelelement spelelement);
    
}
