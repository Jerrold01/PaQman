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
public class Vakje implements DrawInterface {
    
    private boolean muur;
    private int posX;
    private int posY;
    private Spelelement element;
    
    public Vakje(Graphics g, int posX, int posY, String element) {
        this.posX = posX;
        this.posY = posY;
        
        switch(element){
            case "m":
                muur = true;
                break;
            case "b": 
                this.element = new Bolletje();
                break;
            case "s":
                this.element = new Superbolletje();
                break;
            case "p":
                this.element = new Paqman();
        }

        this.draw(g, this);
    }
    
    @Override
    public void draw(Graphics g, Vakje vakje){
        g.setColor(Color.BLACK);
        g.drawRect(posX*30, posY*30, 30, 30);
        
        //Als het vakje een muur is, vullen we deze op.
        if(muur){
            g.fillRect(posX*30, posY*30, 30, 30);
        }
        
        //Als het vakje een element bevat, moet dit element zichzelf gaan tekenen.
        if(element != null){
            element.draw(g, vakje);
        }
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
}
