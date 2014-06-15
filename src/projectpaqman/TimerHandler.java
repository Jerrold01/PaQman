/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.event.*;
import javax.swing.Timer;

/**
 *
 * @author kevinwareman
 */
public class TimerHandler implements ActionListener {
    
    private Timer gameTimer;
    private Timer textTimer;
    private Timer sbTimer;
    private Timer puTimer; 
    private GameEventListener gameEventHandler;
    
    public TimerHandler(GameEventHandler gameEventHandler){
        gameTimer = new Timer(500, this);
        textTimer = new Timer(1000, this);
        sbTimer = new Timer(10000, this);
        puTimer = new Timer(7500, this);    
        this.gameEventHandler = gameEventHandler;
    }
    
    public void startGameTimer(){
        gameTimer.start();
    }
    
    public void stopGameTimer(){
        gameTimer.stop();
    }
    
    public void startTextTimer(){
        textTimer.start();
    }
    
    public void stopTextTimer(){
        textTimer.stop();
    }
    
    public void startSbTimer(){
        sbTimer.start();
    }
    
    public void stopSbTimer(){
        sbTimer.stop();
    }
    
    public void startPuTimer(){
        puTimer.start();
    }
    
    public void stopPuTimer(){
        puTimer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(textTimer)){
            stopTextTimer();
            gameEventHandler.gameEventOccurred(new GameEvent(GameEventType.TEXTTIMER));
        }else if(actionEvent.getSource().equals(sbTimer)){
            gameEventHandler.gameEventOccurred(new GameEvent(GameEventType.ONVERSLAANBAAR));          
            stopSbTimer();
        }else if(actionEvent.getSource().equals(puTimer)){
            gameEventHandler.gameEventOccurred(new GameEvent(GameEventType.POWERUP));
            stopPuTimer();           
        }else if(actionEvent.getSource().equals(gameTimer)){
            gameEventHandler.gameEventOccurred(new GameEvent(GameEventType.TIMER));
        }
    }
}
