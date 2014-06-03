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
    private EventType eventType;
    
    GameEvent(EventType eventType){
        this.eventType = eventType;
    }
    
    GameEvent(Object source, EventType eventType){
        this.source = source;
        this.eventType = eventType;
    }
    
    public Object getSource(){
        return source;
    }
    
    public EventType getEventType(){
        return eventType;
    }
}
