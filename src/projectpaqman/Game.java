/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import javax.swing.JOptionPane;

/**
 *
 * @author kevinwareman
 */
public class Game implements GameEventListener {
 
    private MainFrame frame;
    private Level level;
    private Menu menu;
    private Store store;
    private GameEventHandler gameEventHandler;
    private TimerHandler timerHandler;
    
    private int aantal_levens;
    private int aantal_punten;
    private boolean puntenverdubbelaar;
    
    public static void main(String[] args) {
        Game game = new Game();
    }

    Game(){
        createComponents();
        resetStats();
    }
    
    private void createComponents(){
        gameEventHandler = new GameEventHandler();
        gameEventHandler.addGameEventListener(this);
                
        frame = new MainFrame();   
        menu = new Menu(gameEventHandler);  
        store = new Store(gameEventHandler);

        timerHandler = new TimerHandler(gameEventHandler);
        level = new Level(1, gameEventHandler);
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(level, BorderLayout.CENTER);
  
        level.requestFocus();
        frame.setVisible(true);
    }
    
    private void resetStats(){
        aantal_levens = 3;
        aantal_punten = 0;
        puntenverdubbelaar = false;
        
        menu.setLevens(aantal_levens);
        menu.setPunten(aantal_punten);
        menu.setLevel(level.getLevel());
        menu.setPowerup(null);
    }
    
    private void nextLevel(){
        gameEventHandler = new GameEventHandler();
        gameEventHandler.addGameEventListener(this);
        timerHandler = new TimerHandler(gameEventHandler);
        timerHandler.setGameEventListener(gameEventHandler);
        menu.setGameEventListener(gameEventHandler);
        store.setGameEventListener(gameEventHandler);
        Level newLevel = new Level(level.getLevel()+1, gameEventHandler);
        
        frame.remove(level);
        level.delete();
        
        level = newLevel;
        frame.add(level);
        menu.setLevel(level.getLevel());        
        gameEventHandler.gameEventOccurred(new GameEvent(this, GameEventType.START));
    }
    
    private void restart(){
        gameEventHandler = new GameEventHandler();
        gameEventHandler.addGameEventListener(this);
        timerHandler = new TimerHandler(gameEventHandler);
        timerHandler.setGameEventListener(gameEventHandler);
        menu.setGameEventListener(gameEventHandler);
        store.setGameEventListener(gameEventHandler);
        
        frame.remove(level);
        level.delete();
        level = new Level(1, gameEventHandler);
        
        frame.add(level, BorderLayout.CENTER);
        resetStats();
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case START:
                timerHandler.startGameTimer();
                timerHandler.startTextTimer();
                break;
            case HERSTART:
                restart();
                break;
            case PAUZEER:
                timerHandler.stopGameTimer();
                timerHandler.stopTextTimer();
                break;
            case NEXTLEVEL:
                if(level.getLevel() < 3){
                    nextLevel();
                }else{
                    JOptionPane.showMessageDialog(null, "Hoera, je hebt de game uitgespeeld! \n Je had " + aantal_punten + " punten en " + aantal_levens + " levens.");
                    restart();
                }
                break;
            case STORE:
                store.setVisible(true);
                break;
            case DEAD:
                if(aantal_levens > 1){
                    aantal_levens--;
                    menu.setLevens(aantal_levens);
                }
                else{
                    restart();
                    menu.setStartknop();
                    JOptionPane.showMessageDialog(null, "GAME OVER \n Je hebt geen levens meer");
                }
                break;
            case POWERUP:
                if(gameEvent.getPowerup() != null){
                    timerHandler.stopPuTimer();
                    timerHandler.startPuTimer();
                    switch(gameEvent.getPowerup()){
                        case PUNTENVERDUBBELAAR:
                            puntenverdubbelaar = true;
                            menu.setPowerup(gameEvent.getPowerup().name());
                            break;
                        default:
                            menu.setPowerup(gameEvent.getPowerup().name());
                            break;                           
                    }
                }
                else{
                    puntenverdubbelaar = false;
                    menu.setPowerup(null);
                }
                break;
            case EATBOLLETJE:
                //Kijk of er momenteen een puntenverdubbelaar actief is. Zo ja worden alle gekregen punten verdubbeld.
                if(puntenverdubbelaar){
                    aantal_punten += 20;    
                    if(aantal_punten >= 1000 && String.valueOf(Math.abs((long)aantal_punten-20)).charAt(0) != String.valueOf(Math.abs((long)aantal_punten)).charAt(0)){
                        level.spawnPowerup();
                    }
                }else{
                    aantal_punten += 10;    
                    if(aantal_punten >= 1000 && String.valueOf(Math.abs((long)aantal_punten-10)).charAt(0) != String.valueOf(Math.abs((long)aantal_punten)).charAt(0)){
                        level.spawnPowerup();
                    }
                }
                menu.setPunten(aantal_punten);
                break;
            case EATSUPERBOLLETJE:
                timerHandler.stopSbTimer();
                timerHandler.startSbTimer();
                break;
            case EATKERS:
                //Kijk of er momenteen een puntenverdubbelaar actief is. Zo ja worden alle gekregen punten verdubbeld.
                if(puntenverdubbelaar){
                    aantal_punten += 200;    
                    if(aantal_punten >= 1000 && String.valueOf(Math.abs((long)aantal_punten-200)).charAt(0) != String.valueOf(Math.abs((long)aantal_punten)).charAt(0)){
                        level.spawnPowerup();
                    }
                }else{
                    aantal_punten += 100;    
                    if(aantal_punten >= 1000 && String.valueOf(Math.abs((long)aantal_punten-100)).charAt(0) != String.valueOf(Math.abs((long)aantal_punten)).charAt(0)){
                        level.spawnPowerup();
                    }
                }
                menu.setPunten(aantal_punten);
                break;
            case EATSPOOK:
                //Kijk of er momenteen een puntenverdubbelaar actief is. Zo ja worden alle gekregen punten verdubbeld.
                if(puntenverdubbelaar){
                    aantal_punten += 400;    
                    if(aantal_punten >= 1000 && String.valueOf(Math.abs((long)aantal_punten-400)).charAt(0) != String.valueOf(Math.abs((long)aantal_punten)).charAt(0)){
                        level.spawnPowerup();
                    }
                }else{
                    aantal_punten += 200;    
                    if(aantal_punten >= 1000 && String.valueOf(Math.abs((long)aantal_punten-200)).charAt(0) != String.valueOf(Math.abs((long)aantal_punten)).charAt(0)){
                        level.spawnPowerup();
                    }
                }
                menu.setPunten(aantal_punten);
                break;
            case PAQMANHELPER:
                //Kijkt of de speler genoeg punten heeft om paqmanhelper te kopen. Zo niet krijgt de speler een melding.
                if(aantal_punten >= 1500){
                    aantal_punten -= 1500;
                    level.spawnPaqmanHelper();
                    menu.setPunten(aantal_punten);
                }else{
                    JOptionPane.showMessageDialog(null, "Je hebt nog niet genoeg punten voor deze aankoop.", "Puntentekort", JOptionPane.PLAIN_MESSAGE);
                }
                break;
            case EXTRALEVEN:
                //Kijkt of de speler genoeg punten heeft om een extra leven te kopen. Zo niet krijgt de speler een melding.
                if(aantal_punten >= 2000){
                    aantal_punten -= 2000;
                    aantal_levens++;
                    menu.setPunten(aantal_punten);
                    menu.setLevens(aantal_levens);
                }else{
                    JOptionPane.showMessageDialog(null, "Je hebt nog niet genoeg punten voor deze aankoop.", "Puntentekort", JOptionPane.PLAIN_MESSAGE);
                }
                break;
        }
    }
}
