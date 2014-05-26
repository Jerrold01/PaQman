/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author kevinwareman
 */
public class LevelTimerTask extends TimerTask {
    
    private ArrayList<GameEventListener> gameEventListeners = new ArrayList();
    
    public void addGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.add(gameEventListener);
    }
    
    public void removeGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.remove(gameEventListener);
    }
    
    @Override
    public void run(){
        for(GameEventListener gameEventListener: gameEventListeners){
            gameEventListener.gameEventOccurred(new GameEvent());
        }
    }
}
