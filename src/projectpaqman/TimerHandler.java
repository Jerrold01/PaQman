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
    private GameEventListener gameEventListener;
    
    public TimerHandler(GameEventListener gameEventListener){
        gameTimer = new Timer(500, this);
        textTimer = new Timer(1000, this);
        sbTimer = new Timer(10000, this);
        puTimer = new Timer(7500, this);    
        this.gameEventListener = gameEventListener;
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
    
    public boolean isSbTimerRunning(){
        return sbTimer.isRunning();
    }
    
    public void startPuTimer(){
        puTimer.start();
    }
    
    public void stopPuTimer(){
        puTimer.stop();
    }
    
    public boolean isPuTimerRunning(){
        return puTimer.isRunning();
    }
    
    public void setGameEventListener(GameEventListener gameEventListener){
        this.gameEventListener = gameEventListener;
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(textTimer)){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.TEXTTIMER));
            stopTextTimer();
        }else if(actionEvent.getSource().equals(sbTimer)){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.ONVERSLAANBAAR));       
            stopSbTimer();
        }else if(actionEvent.getSource().equals(puTimer)){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.POWERUP));
            stopPuTimer(); 
        }else if(actionEvent.getSource().equals(gameTimer)){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.TIMER));
        }
    }
}
