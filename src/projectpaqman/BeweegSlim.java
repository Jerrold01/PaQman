/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.util.*;

/**
 *
 * @author kevinwareman
 */
public class BeweegSlim implements BeweegStrategy {
    
    Queue<Vakje> queue = new LinkedList();
    
    @Override
    public void move(Spelelement spelelement, GameEventListener gameEventListener){
        //Vakje paqman = findPaqman(spelelement);
    }
    
    public Vakje findPaqman(Spelelement spelelement){
        Vakje paqman = null;
        ArrayList<Vakje> checklist = new ArrayList();
        Boolean check = false;
        queue.offer(spelelement.vakje);
        while(!queue.isEmpty() && paqman == null){
            Vakje vakje = queue.poll();
            checklist.add(vakje);
            for(Spelelement element : vakje.getElementen()){
                if(element instanceof Paqman){
                    paqman = vakje;
                }
            }

            for(HashMap.Entry<Windrichting, Vakje> buurman : vakje.getBuren().entrySet()){
                if(!buurman.getValue().getMuur()){
                    for(Vakje vak : checklist){
                        if(buurman.getValue().equals(vak)){
                            check = true;               
                        }
                    } 
                    
                    if(!check){
                        queue.offer(buurman.getValue());  
                    }
                    check = false;
                }
            }
        }
        return paqman;
    }
}
