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
    
    private EventType eventType;
    
    GameEvent(EventType eventType){
        this.eventType = eventType;
        switch(eventType){
            case PAUZEER:
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){
                    System.out.println(e);
                    
                }
        }
    }
    
    public EventType getEventType(){
        return eventType;
    }
}
