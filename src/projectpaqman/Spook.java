/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author Jerrold
 */
public class Spook extends Spelelement implements GameEventListener{
    
    private BeweegStrategy beweegstrategy;
    private Vakje startVakje;
    private boolean onverslaanbaar;
    private boolean spookjesvriezer;
    
    public Spook(Vakje vakje, GameEventListener gameEventListener, BeweegStrategy beweegStrategy){
        super(vakje, gameEventListener);
        this.beweegstrategy = beweegStrategy;
        this.startVakje = vakje;
        this.onverslaanbaar = false;
        this.spookjesvriezer = false;
    }
    
    private void move(){
        if(!spookjesvriezer){
            if(onverslaanbaar && beweegstrategy instanceof BeweegSlim){
                beweegstrategy = new BeweegBang();
                beweegstrategy.move(this, gameEventListener);
                beweegstrategy = new BeweegSlim();
            }else if(onverslaanbaar && beweegstrategy instanceof BeweegDronken){
                beweegstrategy = new BeweegBang();
                beweegstrategy.move(this, gameEventListener);
                beweegstrategy = new BeweegDronken();
            }else{
                beweegstrategy.move(this, gameEventListener);           
            }
        }
    }
    
    @Override
    protected void draw(Graphics g) {
        if(onverslaanbaar){
            g.setColor(Color.GREEN);
        }else if(spookjesvriezer){
            g.setColor(Color.BLUE);
        }else{
            g.setColor(Color.RED);
        }
        g.drawRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.fillRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
    }    
    
    @Override
    protected void respawn(){
        Vakje nieuwVakje = getRespawnVakje(startVakje);
        nieuwVakje.addElement(this);
        vakje.removeElement(this);
        vakje = nieuwVakje;
    }
    
    private Vakje getRespawnVakje(Vakje startVakje){
        boolean gevaar = false;
        for(int i=0; i<startVakje.getElementen().size(); i++){
            if(startVakje.getElementen().get(i) instanceof Paqman && startVakje.getElementen().get(i) instanceof PaqmanHelper){
                gevaar = true;
            } 
        }
        
        for(HashMap.Entry<Windrichting, Vakje> buurman : startVakje.getBuren().entrySet()){
                    for(Spelelement element: buurman.getValue().getElementen()){
                    if(element instanceof Paqman || element instanceof PaqmanHelper){
                        gevaar = true;
                    }
                }            
            for(HashMap.Entry<Windrichting, Vakje> buur : buurman.getValue().getBuren().entrySet()){
                for(Spelelement element: buur.getValue().getElementen()){
                    if(element instanceof Paqman || element instanceof PaqmanHelper){
                        gevaar = true;
                    }
                }
                for(HashMap.Entry<Windrichting, Vakje> buurmannen : buur.getValue().getBuren().entrySet()){
                    for(Spelelement element: buurmannen.getValue().getElementen()){
                        if(element instanceof Paqman || element instanceof PaqmanHelper){
                            gevaar = true;
                        }
                    }
            }
            }
            
        }
        
        if(gevaar){
            return getRespawnVakje(getRandomVakje(startVakje));
        }else{
            return startVakje;
        }
    }
    
    private Vakje getRandomVakje(Vakje vakje){
        for(int i=0; i< 40; i++){
            int windrichtingInt = new Random().nextInt(Windrichting.values().length);
            Windrichting windrichting = Windrichting.values()[windrichtingInt];
            HashMap<Windrichting, Vakje> buren = vakje.getBuren();
            vakje = buren.get(windrichting);
            if(vakje != null){
                if(vakje.getMuur() && i == 39){
                    i--;
                }                
            }
            else if(vakje == null && i == 39){
                i--;
            }
        }
        return vakje;
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case DEAD:
                respawn();
                break;
            case TIMER:
                move();
                if(vakje != null){
                    for(int i=0; i<vakje.getElementen().size(); i++){
                        if(vakje.getElementen().get(i) instanceof Paqman){
                            if(onverslaanbaar){
                                gameEventListener.gameEventOccurred(new GameEvent(EventType.EATSPOOK));
                            }else{
                                gameEventListener.gameEventOccurred(new GameEvent(EventType.DEAD));
                            }
                            respawn();
                        } else if(vakje.getElementen().get(i) instanceof PaqmanHelper){
                            respawn();
                        }
                    }
                }
                break;
            case MOVE:
                if(vakje != null){
                    for(int i=0; i<vakje.getElementen().size(); i++){
                        if(vakje.getElementen().get(i) instanceof Paqman){
                            if(onverslaanbaar){
                                gameEventListener.gameEventOccurred(new GameEvent(EventType.EATSPOOK));
                            }else{
                                gameEventListener.gameEventOccurred(new GameEvent(EventType.DEAD));
                            }
                            respawn();
                        } else if(vakje.getElementen().get(i) instanceof PaqmanHelper){
                            respawn();
                        }
                    }  
                }
                break;
            case POWERUP:
                if(gameEvent.getPowerup() != null){
                    switch(gameEvent.getPowerup()){
                        case SPOOKJESVRIEZER:
                            spookjesvriezer = true;
                            break;
                    }                    
                }else{
                    spookjesvriezer = false;
                }
                break;
            case ONVERSLAANBAAR:
                if(onverslaanbaar){
                    onverslaanbaar = false;
                }else{
                    onverslaanbaar = true;
                }
                break;
        }
    }
}

  
    

