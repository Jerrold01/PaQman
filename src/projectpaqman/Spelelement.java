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
public abstract class Spelelement implements DrawInterface {
    
    @Override
    public void draw(Graphics g, Vakje vakje){
        if(this instanceof Bolletje){
            this.draw(g, vakje);
        }
    }
    
//        switch (){
//            case Bolletje():
//                g.drawRect(posX, posY, 30, 30);
//                Bolletje b = new Bolletje();
//                b.draw(g, posX, posY);
//                break;
//            case superbolletje:
//                g.drawRect(posX, posY, 30, 30);
//                Superbolletje s = new Superbolletje();
//                s.draw(g, posX, posY);
//                break;
//            case muur:
//                g.drawRect(posX, posY, 30, 30);
//                g.fillRect(posX, posY, 30, 30);
//                this.muur = true;
//                break;
//            case leeg:
//                g.drawRect(posX, posY, 30, 30);
//                break;
}
