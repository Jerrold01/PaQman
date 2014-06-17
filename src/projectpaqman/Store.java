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
 * @author Jerrold Hogervorst
 */
public class Store extends JFrame {
    
    private JButton paqmanhelperknop;
    private JButton extralevenknop;
    
    private JLabel paqmanhelper;
    private JLabel extraleven;
    private GameEventListener gameEventListener;
    
    public Store(GameEventListener gameEventListener){
        setSize(new Dimension(300, 120));
        setTitle("PaQman Store");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        
        this.gameEventListener = gameEventListener;
        paqmanhelperknop = new JButton("Kopen");
        extralevenknop = new JButton("Kopen");
        paqmanhelper = new JLabel("Paqman Helper (1500 Punten)");
        extraleven = new JLabel("Extra Leven (2000 Punten)");
        
        paqmanhelperknop.addActionListener(new paqmanHelperClickListener());
        extralevenknop.addActionListener(new extraLevenClickListener());

        add(paqmanhelper);
        add(paqmanhelperknop);
        add(extraleven);
        add(extralevenknop);
    }
    
    /**
     * De methode die een nieuwe gameEventListener zet voor de store.
     * @param gameEventListener De nieuwe gameEventListener
     */
    public void setGameEventListener(GameEventListener gameEventListener){
        this.gameEventListener = gameEventListener;
    }
    
    /**
     * De methode die kijkt of er op de koop knop van de paqmanhelper wordt geklikt en dan het juiste event verstuurd.
     */
    public class paqmanHelperClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.PAQMANHELPER));
        }
    }
    
    /**
     * De methode die kijkt of er op de koop knop van de extra leven wordt geklikt en dan het juiste event verstuurd.
     */
    public class extraLevenClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.EXTRALEVEN));
        }
    }
}