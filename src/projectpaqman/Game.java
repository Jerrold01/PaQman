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
        aantal_levens = 3;
        aantal_punten = 0;
        onverslaanbaar = false;
        gestart = true;
        gepauzeerd = false;
        createComponents();
    }
    
    private void createComponents(){
        frame = new MainFrame(new BorderLayout());
        menu = new Menu(this);
        level = new Level("Level 1", 1000, 750);
        level.addGameEventListener(this);
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(level, BorderLayout.CENTER);
  
        level.requestFocus();
        frame.setVisible(true);
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
    
    public void restart(){
        Game newGame = new Game();
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case HERSTART:
                if(getGestart()){
                    
                }else{

                }
                break;
            case PAUZEER:
                if(getGepauzeerd()){

                }else{

                }
                break;
            case EATBOLLETJE:
                aantal_punten += 10;
                menu.setPunten(aantal_punten);
                break;
            case EATSUPERBOLLETJE:
                setOnverslaanbaar(true);
                break;
            case EATKERS:
                aantal_punten += 100;
                menu.setPunten(aantal_punten);
                break;
            case EATSPOOK:
                aantal_punten += 200;
                menu.setPunten(aantal_punten);
                break;
            case DEAD:
                if(aantal_levens != 0){
                aantal_levens--;
                menu.setLevens(aantal_levens);
                }
                else{
                    restart();
                }
                
                break;
            
        }
    }
}
