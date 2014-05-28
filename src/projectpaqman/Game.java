/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author kevinwareman
 */
public class Game implements GameEventListener {
 
    private MainFrame frame;
    private JPanel main;
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
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(level, BorderLayout.CENTER);
  
        level.requestFocus();
        frame.setVisible(true);
    }
  
    public int getAantalLevens(){
        return aantal_levens;
    }
    
    public void setAantalLevens(int aantal_levens){
        this.aantal_levens = aantal_levens;
    }
    
    public int getAantalPunten(){
        return aantal_punten;
    }
    
    public void setAantalPunten(int aantal_punten){
        this.aantal_punten = aantal_punten;
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
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case HERSTART:
                if(getGestart()){
                    
                }else{

                }
            case PAUZEER:
                if(getGepauzeerd()){
                    setGepauzeerd(false);
                }else{
                    setGepauzeerd(true);
                }
        }
    }
}
