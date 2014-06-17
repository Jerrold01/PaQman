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
public class BeweegBang implements BeweegStrategy {
    
    @Override
    public void move(Spelelement spelelement){
       
        Vakje nieuwVakje = nextVakje(spelelement);
        nieuwVakje.addElement(spelelement);
        spelelement.vakje.removeElement(spelelement);
        spelelement.vakje = nieuwVakje;
    }
    
    //returned het eerstvolgende vakje terug welke het sneltste is richging paqman
    private Vakje nextVakje(Spelelement spelelement){
        Node paqman = null;
        Queue<Node> queue = new LinkedList();
        Node root = new Node(spelelement.vakje);
        queue.offer(root);
        while(!queue.isEmpty() && paqman == null){
            Node node = queue.poll();
            Vakje vakje = node.getData();
            for(Spelelement element : vakje.getElementen()){
                if(element instanceof Paqman){
                    paqman = node;
                }
            }

            for(HashMap.Entry<Windrichting, Vakje> buurman : vakje.getBuren().entrySet()){
                if(!buurman.getValue().getMuur()){
                    Iterator<Node> it = queue.iterator();
                    boolean check = false;
                    while(it.hasNext()){
                        Vakje queueVakje = it.next().getData();
                        if(queueVakje.equals(buurman.getValue())){
                           check = true;
                        }
                    }
                    
                    if(!check){
                        Node child = new Node(buurman.getValue());
                        child.setParent(node);
                        queue.offer(child);
                    }
                }
            }
        }
        
        Vakje nextVakje = paqman.getNextNode().getData();
        return reverseDirection(spelelement, nextVakje);
    }
    
    //returned het tegenovergestelde vakje van het eerste vakje van het kortste pad algoritme richting paqman.
    private Vakje reverseDirection(Spelelement spelelement, Vakje vakje){
        Vakje nextVakje;
        if(spelelement.vakje.getBuren().get(Windrichting.NOORD).equals(vakje)){
            nextVakje = spelelement.vakje.getBuren().get(Windrichting.ZUID);
            if(nextVakje.getMuur()){
                nextVakje = spelelement.vakje.getBuren().get(Windrichting.WEST);
                if(nextVakje.getMuur()){
                    nextVakje = reverseDirection(spelelement, nextVakje);
                }
            }
        }else if(spelelement.vakje.getBuren().get(Windrichting.ZUID).equals(vakje)){
            nextVakje = spelelement.vakje.getBuren().get(Windrichting.NOORD);
            if(nextVakje.getMuur()){
                nextVakje = spelelement.vakje.getBuren().get(Windrichting.OOST);
                if(nextVakje.getMuur()){
                    nextVakje = reverseDirection(spelelement, nextVakje);
                }
            }
        }else if(spelelement.vakje.getBuren().get(Windrichting.WEST).equals(vakje)){
            nextVakje = spelelement.vakje.getBuren().get(Windrichting.OOST);
            if(nextVakje.getMuur()){
                nextVakje = spelelement.vakje.getBuren().get(Windrichting.ZUID);
                if(nextVakje.getMuur()){
                    nextVakje = reverseDirection(spelelement, nextVakje);
                }
            }
        }else{
            nextVakje = spelelement.vakje.getBuren().get(Windrichting.WEST);
            if(nextVakje.getMuur()){
                nextVakje = spelelement.vakje.getBuren().get(Windrichting.NOORD);
                if(nextVakje.getMuur()){
                    nextVakje = reverseDirection(spelelement, nextVakje);
                }
            }
        }
        
        return nextVakje;
    }
}
