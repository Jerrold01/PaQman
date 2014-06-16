/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.util.*;
/**
 *
 * @author Jerrold
 */
public class Spook extends Spelelement implements GameEventListener{
    
    private Vakje startVakje;
    private BeweegStrategy beweegstrategy;
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
    
    private Vakje getRespawnVakje(Vakje vakje){
        boolean gevaar = false;
        int i = 0;
        ArrayList<Vakje> checkList = new ArrayList();
        Queue<Vakje> queue = new LinkedList();
        queue.add(vakje);
        
        while(i<64 && gevaar == false){
            Vakje current = queue.poll();
            if(!current.getMuur()){
                if(!checkList.contains(current) && !queue.contains(current)){
                    for(HashMap.Entry<Windrichting, Vakje> buurman : current.getBuren().entrySet()){            
                        for(Spelelement element: buurman.getValue().getElementen()){
                            if(element instanceof Paqman || element instanceof PaqmanHelper){
                                gevaar = true;
                            }
                        } 
                        queue.add(buurman.getValue());
                        checkList.add(current);
                    }
                }
                i++;
            }
        }
        
        if(gevaar){
            return getRespawnVakje(getRandomVakje(startVakje));
        }else{
            return vakje;
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
            else if(vakje == null){
                return getRandomVakje(startVakje);
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
                                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.EATSPOOK));
                            }else{
                                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.DEAD));
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
                                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.EATSPOOK));
                            }else{
                                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.DEAD));
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
            case EATSUPERBOLLETJE:
                onverslaanbaar = true;
                break;
        }
    }
}

  
    

