/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.util.EventObject;

/**
 *
 * @author kevinwareman
 */
public class GameEvent extends EventObject{
    
    private boolean gepauzeerd;
    private boolean onverslaanbaar;
    private int aantal_levens;
    private int aantal_punten;
    
    GameEvent(Object source, boolean gepauzeerd, boolean onverslaanbaar, int aantal_levens, int aantal_punten){
        super(source);
        this.gepauzeerd = gepauzeerd;
        this.onverslaanbaar = onverslaanbaar;
        this.aantal_levens = aantal_levens;
        this.aantal_punten = aantal_punten;
    }
  
    public int getAantalLevens(){
        return aantal_levens;
    }
    
    public void setAantalLevens(int aantal_levens){
        this.aantal_levens = aantal_levens;
    }
    
    public int getAantalPunten(){
        return aantal_punten;
    }
    
    public void setAantalPunten(int aantal_punten){
        this.aantal_punten = aantal_punten;
    }
    
    public boolean getOnverslaanbaar(){
        return onverslaanbaar;
    }
    
    public void setOnverslaanbaar(boolean onverslaanbaar){
        this.onverslaanbaar = onverslaanbaar;
    }
    
    public boolean getGepauzeerd(){
        return gepauzeerd;
    }
    
    public void setGepauzeerd(boolean gepauzeerd){
        this.gepauzeerd = gepauzeerd;
    }
}
