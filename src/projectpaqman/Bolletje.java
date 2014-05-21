/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;

/**
 *
 * @author Jerrold
 */
public class Bolletje extends Spelelement {
    
    public void draw(Graphics g, int posX, int posY) {
        g.setColor(Color.BLUE);
        g.drawOval(posX, posY, 30, 30);
        g.fillOval(posX, posY, 30, 30);
    }
}
