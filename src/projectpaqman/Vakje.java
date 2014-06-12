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
    private boolean transparant;
    private final int posX;
    private final int posY;
    private ArrayList<Spelelement> elementen = new ArrayList();
    private HashMap<Windrichting, Vakje> buren = new HashMap();
    
    public Vakje(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.transparant = false;
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
    
    public void removeElement(Spelelement element){
        for(int i=0; i<elementen.size(); i++) {
            if(elementen.get(i).equals(element)){
                elementen.remove(element);
            }
        }
    }
    
    public ArrayList<Spelelement> getElementen(){
        return elementen;
    }
    
    public HashMap<Windrichting, Vakje> getBuren(){
        return buren;
    }
    
    public void setBuren(Windrichting windrichting, Vakje vakje){
        buren.put(windrichting, vakje);
    }
    
    public boolean getMuur(){
        return muur;
    }
    
    public void setMuur(boolean muur){
        this.muur = muur;
    }
    
    public boolean getTransparent(){
        return transparant;
    }
    
    public void setTransparent(boolean transparant){
        this.transparant = transparant;
    }
    
    public void draw(Graphics g){  
        g.setColor(Color.BLACK);
        
        //Als het vakje een muur is, vullen we deze op.
        if(muur && !transparant){
            g.fillRect(posX*25, posY*25, 25, 25);
            g.drawRect(posX*25, posY*25, 25, 25);
        }else if(muur && transparant){
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(posX*25, posY*25, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRect(posX*25, posY*25, 25, 25);
        }else{
            g.drawRect(posX*25, posY*25, 25, 25);
        }
        
        //Als het vakje een element bevat, moet dit element zichzelf gaan tekenen.
        if(!elementen.isEmpty()){
            for(Spelelement element : elementen){
                element.draw(g);   
            }
        }
    }
}
