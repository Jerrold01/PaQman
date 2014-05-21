/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Jerrold
 */
public class Vakje implements DrawInterface {
    
    private boolean muur;
    private int posX;
    private int posY;
    private ArrayList<Spelelement> elementen = new ArrayList();
    
    public Vakje(Graphics g, int posX, int posY, String element) {
        this.posX = posX;
        this.posY = posY;
        
        switch(element){
            case "m":
                muur = true;
                break;
            case "b": 
                this.elementen.add(new Bolletje(this));
                break;
            case "s":
                this.elementen.add(new Superbolletje(this));
                break;
            case "p":
                this.elementen.add(new Paqman(this));
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
        if(!elementen.isEmpty()){
            for(Spelelement element : elementen){
                element.draw(g, vakje);   
            }
        }
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
}
