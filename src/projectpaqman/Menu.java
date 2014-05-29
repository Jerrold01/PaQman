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
    private JLabel level_nummer;
    private GameEventListener gameEventListener;
    
    public Menu(GameEventListener gameEventListener){
        this.setPreferredSize(new Dimension(600, 40));
        this.setBackground(Color.LIGHT_GRAY); 
        this.gameEventListener = gameEventListener;
        
        startknop = new JButton("Start");
        pauzeknop = new JButton("Pauzeer");
        level_nummer = new JLabel("Level 1");
        aantal_punten = new JLabel("Punten: 0");
        aantal_levens = new JLabel("Levens: 3");
        
        pauzeknop.addActionListener(new pauzeClickListener());
        startknop.addActionListener(new startClickListener());
        
        this.add(startknop);
        this.add(pauzeknop);
        this.add(aantal_punten);
        this.add(aantal_levens);
        this.add(level_nummer);
    }
    
    public void setStartknop(){
        if(startknop.getText().equalsIgnoreCase("Start")){
            startknop.setText("Herstart");
        }else{
            startknop.setText("Start");
        }
    }
    
    public void setPauzeknop(){
        if(startknop.getText().equalsIgnoreCase("Pauzeer")){
            startknop.setText("Hervat");
        }else{
            startknop.setText("Pauzeer");
        }        
    }
    
    public void setPunten(int aantal_punten){
        this.aantal_punten.setText("Punten: " + String.valueOf(aantal_punten));
    }
    
    public void setLevens(int aantal_levens){
        this.aantal_levens.setText("Levens: " + String.valueOf(aantal_levens));
    }
    
    public class pauzeClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(EventType.PAUZEER));
        }
    }
    
    public class startClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(EventType.HERSTART));
        }
    }
}
