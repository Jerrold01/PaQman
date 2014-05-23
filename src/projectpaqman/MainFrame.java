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
public class MainFrame extends JFrame {
    
    private JPanel main;
    private Menu menu;
    private Level level;
    
    public MainFrame(){
        createComponents();
    }
    
    public void createComponents(){
        setSize(new Dimension(600, 400));
        setTitle("PaQman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        main = new JPanel( new BorderLayout());
        main.setBackground(Color.WHITE);
        this.add(main);
        
        menu = new Menu();
        level = new Level("Level 1", 600, 360);

        main.add(menu, BorderLayout.NORTH);
        main.add(level, BorderLayout.CENTER);
    }
}
