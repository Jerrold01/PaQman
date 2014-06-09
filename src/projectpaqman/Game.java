/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;

/**
 *
 * @author kevinwareman
 */
public class Game implements GameEventListener {
 
    private MainFrame frame;
    private Level level;
    private Menu menu;
    
    private int aantal_levens;
    private int aantal_punten;
    private boolean gestart;
    private boolean gepauzeerd;
    private boolean puntenverdubbelaar;
    
    public static void main(String[] args) {
        Game game = new Game();
    }

    Game(){
        createComponents();
        resetStats();
    }
    
    private void createComponents(){
        frame = new MainFrame(new BorderLayout());          
        menu = new Menu(this);  
        level = new Level(1, 1000, 750);
        level.addGameEventListener(this);
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(level, BorderLayout.CENTER);
  
        level.requestFocus();
        frame.setVisible(true);
        gestart = true;
    }
    
    private void resetStats(){
        aantal_levens = 3;
        aantal_punten = 0;
        gestart = false;
        gepauzeerd = false;
        puntenverdubbelaar = false;
        
        menu.setLevens(aantal_levens);
        menu.setPunten(aantal_punten);
        menu.setLevel(level.getLevel());
    }
    
    private void nextLevel(){
        Level newLevel = new Level(level.getLevel()+1, 1000, 750);
        frame.remove(level);
        level.delete();
        level = newLevel;
        level.addGameEventListener(this);
        frame.add(level);
        menu.setLevel(level.getLevel());        
        level.gameEventOccurred(new GameEvent(this, EventType.START));
    }
    
    private void restart(){
        frame.remove(level);
        level.delete();
        level = new Level(1, 1000, 750);
        level.addGameEventListener(this);
        frame.add(level, BorderLayout.CENTER);
        resetStats();
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case START:
                if(!gestart){
                    gestart = true;
                    level.gameEventOccurred(new GameEvent(this, EventType.START));
                }
                gepauzeerd = false;
                break;
            case HERSTART:
                restart();
                level.gameEventOccurred(gameEvent);
                break;
            case PAUZEER:
                if(!gepauzeerd){
                    gepauzeerd = true;
                    level.gameEventOccurred(gameEvent);
                }
                gestart = false;
                break;
            case NEXTLEVEL:
                if(level.getLevel() < 3){
                    nextLevel();
                }else{
                    level.gameEventOccurred(new GameEvent(EventType.GAMEOVER));
                    gepauzeerd = true;
                }
                break;
            case DEAD:
                if(aantal_levens > 1){
                    aantal_levens--;
                    menu.setLevens(aantal_levens);
                }
                else{
                    restart();
                    menu.setStartknop();
                }
                break;
            case POWERUP:
                if(gameEvent.getPowerup() != null){
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
            case EATKERS:
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
        }
    }
}
