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
    
    /**
     * De methode die de x coördinaat van een vakje terug geeft.
     * @return De x coördinaat van het vakje.
     */
    public int getPosX(){
        return posX;
    }
    
    /**
     * De methode die de y coördinaat van een vakje terug geeft.
     * @return De y coördinaat van het vakje.
     */
    public int getPosY(){
        return posY;
    }
    
    /**
     * De methode die een element toevoegt aan het vakje.
     * @param element Het toe te voegen element
     */
    public void addElement(Spelelement element){
        elementen.add(element);
    }
    
    /**
     * De methode die een element verwijdert van het vakje.
     * @param element Het te verwijderen element.
     */
    public void removeElement(Spelelement element){
        for(int i=0; i<elementen.size(); i++) {
            if(elementen.get(i).equals(element)){
                elementen.remove(element);
            }
        }
    }
    
    /**
     * De methode die de lijst met alle elementen op dit vakje terug geeft.
     * @return Lijst met alle elementen op dit vakje.
     */
    public ArrayList<Spelelement> getElementen(){
        return elementen;
    }
    
    /**
     * De methode die alle buren van dit vakje terug geeft.
     * @return HashMap met alle buren.
     */
    public HashMap<Windrichting, Vakje> getBuren(){
        return buren;
    }
    
    /**
     * De methode die de buren van dit vakje set.
     * @param windrichting De windrichting van de buur.
     * @param vakje Het vakje van de buur.
     */
    public void setBuren(Windrichting windrichting, Vakje vakje){
        buren.put(windrichting, vakje);
    }
    
    /**
     * Geeft terug of het vakje een muur is of niet
     * @return Of het vakje een muur is of niet.
     */
    public boolean getMuur(){
        return muur;
    }
    
    /**
     * De methode die een vakje in een muur kan veranderen of een muur in een gewoon vakje kan veranderen.
     * @param muur De waarde true of false wat bepaald of het een muur moet worden of niet.
     */
    public void setMuur(boolean muur){
        this.muur = muur;
    }
    
    /**
     * Det methode die terug geeft of een vakje transparant is of niet.
     * @return Of een muur transparant is of niet(true of false).
     */
    public boolean getTransparent(){
        return transparant;
    }
    
    /**
     * De methode die een muur transparant maakt of juis niet transparant maakt.
     * @param transparant De waarde true of false wat bepaald of de muur transparant moet worden of niet.
     */
    public void setTransparent(boolean transparant){
        this.transparant = transparant;
    }
    
    /**
     * De methode die het vakje tekent op het speelveld.
     * @param g Het graphics object.
     */
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
