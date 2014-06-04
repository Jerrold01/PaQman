/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
/**
 *
 * @author Jerrold
 */
public class Spook extends Spelelement implements GameEventListener{
    
    private BeweegStrategy beweegstrategy;
    private Vakje startVakje;
    private boolean onverslaanbaar;
    
    public Spook(Vakje vakje, GameEventListener gameEventListener, BeweegStrategy beweegStrategy){
        super(vakje, gameEventListener);
        this.beweegstrategy = beweegStrategy;
        this.startVakje = vakje;
        this.onverslaanbaar = false;
    }
    
    private void move(){
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
    
    @Override
    protected void draw(Graphics g) {
        if(onverslaanbaar){
            g.setColor(Color.GREEN);
        }else{
            g.setColor(Color.RED);
        }
        g.drawRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
        g.fillRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23);
    }    
    
    @Override
    protected void respawn(){
        vakje.removeElement(this);
        startVakje.addElement(this);
        vakje = startVakje;
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
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
                        }
                    }  
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

  
    

