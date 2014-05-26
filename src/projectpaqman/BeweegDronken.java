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
    private Windrichting windrichting;
    
    public void move(HashMap<Windrichting, Vakje> buren, Vakje vakje, Spelelement spelelement, GameEventListener gameEventListener ){
        
        int windrichtingInt = new Random().nextInt(Windrichting.values().length);
        windrichting = Windrichting.values()[windrichtingInt];
        Vakje nieuwVakje = buren.get(windrichting);
        
        
        if(!isTegenovergesteldeWindrichting(windrichting, laatsteWindrichting)){
            if(!nieuwVakje.getMuur()){
                nieuwVakje.addElement(spelelement);
                vakje.removeElement(spelelement);
                spelelement.setVakje(nieuwVakje);
                gameEventListener.gameEventOccurred(new GameEvent());
            }
            laatsteWindrichting = windrichting;
        }
        
    }
    
    public boolean isTegenovergesteldeWindrichting(Windrichting windrichting, Windrichting LaatsteWindrichting){
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
