/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jerrold
 */
public class Menu extends JPanel {

    private JButton startknop; //Tevens herstartknop
    private JButton pauzeknop;
    private JLabel aantal_punten;
    private JLabel aantal_levens;
    private JLabel level_naam;
    private JLabel powerup_naam;
    private GameEventListener gameEventListener;
    
    public Menu(GameEventListener gameEventListener){
        this.setPreferredSize(new Dimension(600, 40));
        this.setBackground(Color.LIGHT_GRAY); 
        this.gameEventListener = gameEventListener;
        
        startknop = new JButton("Start");
        pauzeknop = new JButton("Pauzeer");
        level_naam = new JLabel();
        aantal_punten = new JLabel();
        aantal_levens = new JLabel();
        powerup_naam = new JLabel();
        
        pauzeknop.addActionListener(new pauzeClickListener());
        startknop.addActionListener(new startClickListener());
        
        this.add(startknop);
        this.add(pauzeknop);
        this.add(aantal_punten);
        this.add(aantal_levens);
        this.add(level_naam);
    }
    
    public void setStartknop(){
        if(startknop.getText().equalsIgnoreCase("Start")){
            startknop.setText("Herstart");
        }else{
            startknop.setText("Start");
        }
    }
    
    public void setPauzeknop(){
        if(pauzeknop.getText().equalsIgnoreCase("Pauzeer")){
            pauzeknop.setText("Hervat");
        }else{
            pauzeknop.setText("Pauzeer");
        }        
    }
    
    public void setPunten(int aantal_punten){
        this.aantal_punten.setText("Punten: " + String.valueOf(aantal_punten));
    }
    
    public void setLevens(int aantal_levens){
        this.aantal_levens.setText("Levens: " + String.valueOf(aantal_levens));
    }
    
    public void setLevel(int level_nummer){
        this.level_naam.setText("Level: " + String.valueOf(level_nummer));
    }
    
    public void setPowerup(String powerup_naam){
        this.powerup_naam.setText("Powerup: " + powerup_naam);
    }
    
    public class pauzeClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            if(startknop.getText().equalsIgnoreCase("Herstart")){
                if(pauzeknop.getText().equalsIgnoreCase("Pauzeer")){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.PAUZEER));                
                }else{
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.START));
                }
                setPauzeknop();
            }
        }
    }
    
    public class startClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            if(startknop.getText().equalsIgnoreCase("Start")){
                gameEventListener.gameEventOccurred(new GameEvent(EventType.START));                
            }else{
                gameEventListener.gameEventOccurred(new GameEvent(EventType.HERSTART));
            }
            setStartknop();
        }
    }
}
