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
    private boolean onverslaanbaar;
    private boolean gestart;
    private boolean gepauzeerd;
    
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
        setGestart(true);
    }
    
    private void resetStats(){
        aantal_levens = 3;
        aantal_punten = 0;
        onverslaanbaar = false;
        gestart = false;
        gepauzeerd = false;
        
        menu.setLevens(aantal_levens);
        menu.setPunten(aantal_punten);
        menu.setLevel(level.getLevel());
    }
    
    public boolean getOnverslaanbaar(){
        return onverslaanbaar;
    }
    
    public void setOnverslaanbaar(boolean onverslaanbaar){
        this.onverslaanbaar = onverslaanbaar;
    }
    
    public boolean getGestart(){
        return gestart;
    }
    
    public void setGestart(boolean gestart){
        this.gestart = gestart;
    }
    
    public boolean getGepauzeerd(){
        return gepauzeerd;
    }
    
    public void setGepauzeerd(boolean gepauzeerd){
        this.gepauzeerd = gepauzeerd;
    }
    
    public void setPunten(int aantal_punten){
        this.aantal_punten = aantal_punten;
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
                    setGestart(true);
                    level.gameEventOccurred(new GameEvent(this, EventType.START));
                }
                setGepauzeerd(false);
                break;
            case HERSTART:
                restart();
                level.gameEventOccurred(gameEvent);
                break;
            case PAUZEER:
                if(!gepauzeerd){
                    setGepauzeerd(true);
                    level.gameEventOccurred(gameEvent);
                }
                setGestart(false);
                break;
            case NEXTLEVEL:
                if(level.getLevel() < 3){
                    nextLevel();
                }else{
                    //Game Success
                }
                break;
            case ONVERSLAANBAAR:
                if(onverslaanbaar){
                    setOnverslaanbaar(false);
                }else{
                    setOnverslaanbaar(true);
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
            case EATBOLLETJE:
                aantal_punten += 10;
                menu.setPunten(aantal_punten);
                break;
            case EATKERS:
                aantal_punten += 100;
                menu.setPunten(aantal_punten);
                break;
            case EATSPOOK:
                aantal_punten += 200;
                menu.setPunten(aantal_punten);
                break;
        }
    }
}
