/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author kevinwareman
 */

public class BeweegDronken implements BeweegStrategy {
    
    private Windrichting laatsteWindrichting;
    
    @Override
    public void move(Spelelement spelelement){
        
        int windrichtingInt = new Random().nextInt(Windrichting.values().length);
        Windrichting windrichting = Windrichting.values()[windrichtingInt];
        HashMap<Windrichting, Vakje> buren = spelelement.vakje.getBuren();
        Vakje nieuwVakje = buren.get(windrichting); 
        
        if(!isReverseDirection(windrichting)){
            if(!nieuwVakje.getMuur()){
                nieuwVakje.addElement(spelelement);
                spelelement.vakje.removeElement(spelelement);
                spelelement.setVakje(nieuwVakje);
            }
            else{
                move(spelelement);
            }
            this.laatsteWindrichting = windrichting;
        }
        else{
            move(spelelement);
        }
    }
    
    //Kijkt of het de gekregen windrichting de tegenovergestelde richting is van het laatst gelopen windrichting.
    private boolean isReverseDirection(Windrichting windrichting){
        if(laatsteWindrichting != null){
            switch(windrichting){
                case NOORD:
                    return laatsteWindrichting.equals(Windrichting.ZUID);
                case OOST:
                    return laatsteWindrichting.equals(Windrichting.WEST);
                case ZUID:
                    return laatsteWindrichting.equals(Windrichting.NOORD);
                case WEST:
                    return laatsteWindrichting.equals(Windrichting.OOST);
            }
        }
        else{
            return false;
        }
        return true;
    }
}
