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
        
    public void addGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.add(gameEventListener);
    }
    
    public void removeGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.remove(gameEventListener);
    }
    
    public void clearGameEventListeners(){
        gameEventListeners.clear();
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case EATSUPERBOLLETJE:
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(GameEventType.ONVERSLAANBAAR));
                }
                break;                
            default:
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(gameEvent);
                }
                break;
        }
    }
}
