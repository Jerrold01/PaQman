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
 * @author Jerrold
 */
public class Menu extends JPanel{

    private JButton startknop; //Tevens herstartknop
    private JButton pauzeknop;
    private JLabel aantal_punten;
    private JLabel aantal_levens;
    private JLabel level_nummer;
    
    public Menu(){
        this.setPreferredSize(new Dimension(600, 40));
        this.setBackground(Color.LIGHT_GRAY); 
        
        startknop = new JButton("Start");
        pauzeknop = new JButton("Pauzeer");
        level_nummer = new JLabel("Level 1");
        aantal_punten = new JLabel("Punten: 0");
        aantal_levens = new JLabel("Levens: 3");
        
        this.add(startknop);
        this.add(pauzeknop);
        this.add(aantal_punten);
        this.add(aantal_levens);
        this.add(level_nummer);
    }
}