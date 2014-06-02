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

    public MainFrame(LayoutManager layoutManager){
        setSize(new Dimension(1015, 825));
        setTitle("PaQman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setLayout(layoutManager);
    }
}
