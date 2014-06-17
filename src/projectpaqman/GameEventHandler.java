/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.util.ArrayList;

/**
 *
 * @author kevinwareman
 */
public class GameEventHandler implements GameEventListener{
    
    private ArrayList<GameEventListener> gameEventListeners = new ArrayList();
    private Spelelement elementToAdd;
    
    
    /**
     * Methode die een gameEventListener toevoegt aan de lijst met ontvangers.
     * @param gameEventListener De gameEventListener die moet worden toegevoegd.
     */
    public void addGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.add(gameEventListener);
    }
    
    /**
     * Methode die een gameEventListener verwijdert uit de lijst met ontvangers.
     * @param gameEventListener De gameEventListener die moet worden verwijderd.
     */
    public void removeGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.remove(gameEventListener);
    }
    
    /**
     * De methode die de hele lijst van ontvangers leeg maakt.
     */
    public void clearGameEventListeners(){
        gameEventListeners.clear();
    }
    
    /**
     * Methode die een element klaar zet om toe te voegen aan de lijst met ontvangers nadat de handler klaar is met itereren.
     * @param spelelement Het element dat moet worden toegevoegd.
     */
    public void setElementToAdd(Spelelement spelelement){
        elementToAdd = spelelement;
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){               
            default:
                for(int i=0; i<gameEventListeners.size(); i++){
                    gameEventListeners.get(i).gameEventOccurred(gameEvent);
                }
                
                if(elementToAdd != null){
                    gameEventListeners.add(elementToAdd);
                    elementToAdd = null;
                }
                break;
        }
    }
}
