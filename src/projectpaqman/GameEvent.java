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
    private boolean waarde;
    private int getal;
    
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
    
    GameEvent(EventType eventType, boolean waarde){
        this.eventType = eventType;
        this.waarde = waarde;
    }
    
    GameEvent(EventType eventType, int waarde){
        this.eventType = eventType;
        this.getal = waarde;
    }
    
    public EventType getEventType(){
        return eventType;
    }
    
    public boolean getWaarde(){
        return waarde;
    }
    
    public int getGetal(){
        return getal;
    }
}
