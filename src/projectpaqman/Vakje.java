/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jerrold
 */
public class Vakje {
    
    private boolean muur;
    private int posX;
    private int posY;
    private ArrayList<Spelelement> elementen = new ArrayList();
    private HashMap<String, Vakje> buren = new HashMap();
    
    public Vakje(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public void addElement(Spelelement element){
        elementen.add(element);
    }
    
    public void setBuren(String windrichting, Vakje vakje){
        buren.put(windrichting, vakje);
    }
    
    public void setMuur(boolean muur){
        this.muur = muur;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(posX*30, posY*30, 30, 30);
        
        //Als het vakje een muur is, vullen we deze op.
        if(muur){
            g.fillRect(posX*30, posY*30, 30, 30);
        }
        
        //Als het vakje een element bevat, moet dit element zichzelf gaan tekenen.
        if(!elementen.isEmpty()){
            for(Spelelement element : elementen){
                element.draw(g);   
            }
        }
    }
}
