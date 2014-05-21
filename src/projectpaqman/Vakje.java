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
public class Vakje {
    
    private final boolean muur;
    public int posX;
    public int posY;
    
    public Vakje(boolean muur, int posX, int posY) {
        this.muur = muur;
        this.posX = posX;
        this.posY = posY;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, 30, 30);
    }
}
