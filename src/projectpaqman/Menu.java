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
    private JButton storeknop;
    
    private JLabel aantal_punten;
    private JLabel aantal_levens;
    private JLabel level_naam;
    private JLabel powerup_naam;
    private GameEventListener gameEventListener;
    
    public Menu(GameEventListener gameEventListener){
        setPreferredSize(new Dimension(600, 40));
        setBackground(Color.LIGHT_GRAY); 
        this.gameEventListener = gameEventListener;
        
        startknop = new JButton("Start");
        pauzeknop = new JButton("Pauzeer");
        storeknop = new JButton("Store");
        level_naam = new JLabel();
        aantal_punten = new JLabel();
        aantal_levens = new JLabel();
        powerup_naam = new JLabel();
        
        storeknop.addActionListener(new storeClickListener());
        pauzeknop.addActionListener(new pauzeClickListener());
        startknop.addActionListener(new startClickListener());
        
        add(startknop);
        add(pauzeknop);
        add(storeknop);
        add(aantal_punten);
        add(aantal_levens);
        add(level_naam);
        add(powerup_naam);
    }
    
    /**
     * Verandert de tekst van de startknop naar herstart of start, afhankelijk van de huidige tekst.
     */
    public void setStartknop(){
        if(startknop.getText().equalsIgnoreCase("Start")){
            startknop.setText("Herstart");
        }else{
            startknop.setText("Start");
        }
    }
    
    /**
     * Verandert de tekst van de pauzeknop naar pauzeer of hervat, afhankelijk van de huidige tekst.
     */
    public void setPauzeknop(){
        if(pauzeknop.getText().equalsIgnoreCase("Pauzeer")){
            pauzeknop.setText("Hervat");
        }else{
            pauzeknop.setText("Pauzeer");
        }        
    }
    
    /**
     * Verandert de tekst van het JLabel naar het aantal punten.
     * @param aantal_punten Het aantal punten wat getoond moet worden op het scherm.
     */
    public void setPunten(int aantal_punten){
        this.aantal_punten.setText("Punten: " + String.valueOf(aantal_punten));
    }
    
    /**
     * Verandert de tekst van het JLabel naar het aantal levens.
     * @param aantal_levens Het aantal levens wat getoond moet worden op het scherm.
     */
    public void setLevens(int aantal_levens){
        this.aantal_levens.setText("Levens: " + String.valueOf(aantal_levens));
    }
    
    /**
     * Verandert de tekst van het JLabel naar het level nummer.
     * @param level_nummer Het level nummer welke getoond moet worden.
     */
    public void setLevel(int level_nummer){
        this.level_naam.setText("Level: " + String.valueOf(level_nummer));
    }
    
    /**
     * Verandert de tekst van het JLabel naar de juiste powerup
     * @param powerup_naam De naam van de power up welke getoond moet worden.
     */
    public void setPowerup(String powerup_naam){
        if(powerup_naam == null){
            this.powerup_naam.setText(null);
        }else{
            this.powerup_naam.setText("Powerup: " + powerup_naam);
        }
    }
    
    /**
     * Verandert de gameEventListener waarnaar events moeten worden gestuurd.
     * @param gameEventListener De gameEventListner waarnaar events moeten worden gestuurd.
     */
    public void setGameEventListener(GameEventListener gameEventListener){
        this.gameEventListener = gameEventListener;
    }
 
    /**
     * De listener die kijkt of er op de store button wordt geklikt.
     */
    public class storeClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.STORE));
            if(startknop.getText().equalsIgnoreCase("Herstart")){
                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.PAUZEER));
                setPauzeknop();
            }
        }
    }
        
    /**
     * De listener die kijkt of er op de pauze button wordt geklikt.
     */
    public class pauzeClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            if(startknop.getText().equalsIgnoreCase("Herstart")){
                if(pauzeknop.getText().equalsIgnoreCase("Pauzeer")){
                    gameEventListener.gameEventOccurred(new GameEvent(GameEventType.PAUZEER));                
                }else{
                    gameEventListener.gameEventOccurred(new GameEvent(GameEventType.START));
                }
                setPauzeknop();
            }
        }
    }
    
    /**
     * De listener die kijkt of er op de start button wordt geklikt.
     */
    public class startClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            if(startknop.getText().equalsIgnoreCase("Start")){
                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.START));                
            }else{
                gameEventListener.gameEventOccurred(new GameEvent(GameEventType.HERSTART));
            }
            setStartknop();
        }
    }
}
