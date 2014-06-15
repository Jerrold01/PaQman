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
        
    public void addGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.add(gameEventListener);
    }
    
    public void removeGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.remove(gameEventListener);
    }
    
    public void clearGameEventListeners(){
        gameEventListeners.clear();
    }
    
    public void setElementToAdd(Spelelement spelelement){
        elementToAdd = spelelement;
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case EATSUPERBOLLETJE:
                for(int i=0; i<gameEventListeners.size(); i++){
                    gameEventListeners.get(i).gameEventOccurred(new GameEvent(GameEventType.ONVERSLAANBAAR));
                }
                break;                
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
