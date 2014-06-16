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
        
        paqmanhelperknop.addActionListener(new paqmanHelperListener());
        extralevenknop.addActionListener(new extraLevenListener());

        add(paqmanhelper);
        add(paqmanhelperknop);
        add(extraleven);
        add(extralevenknop);
    }
    
    public void setGameEventListener(GameEventListener gameEventListener){
        this.gameEventListener = gameEventListener;
    }
    
    public class paqmanHelperListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.PAQMANHELPER));
        }
    }
    
    public class extraLevenListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            gameEventListener.gameEventOccurred(new GameEvent(GameEventType.EXTRALEVEN));
        }
    }
}