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
public class GameEvent{
    
    private Object source;
    private Powerups powerup;
    private GameEventType eventType;
    
    GameEvent(GameEventType eventType){
        this.eventType = eventType;
    }
    
    GameEvent(Object source, GameEventType eventType){
        this.source = source;
        this.eventType = eventType;
    }
    
    GameEvent(Powerups powerup, GameEventType eventType){
        this.powerup = powerup;
        this.eventType = eventType;
    }
    
    public Object getSource(){
        return source;
    }
    
    public Powerups getPowerup(){
        return powerup;
    }
    
    public GameEventType getEventType(){
        return eventType;
    }
}
