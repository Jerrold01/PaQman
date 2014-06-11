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
    
    @Override
    public void move(Spelelement spelelement, GameEventListener gameEventListener){
        Vakje nieuwVakje = nextVakje(spelelement);
        nieuwVakje.addElement(spelelement);
        spelelement.vakje.removeElement(spelelement);
        spelelement.vakje = nieuwVakje;
    }
    
    public Vakje nextVakje(Spelelement spelelement){
        Node paqman = null;
        Queue<Node> queue = new LinkedList();
        ArrayList<Vakje> checklist = new ArrayList();
        Node root = new Node(spelelement.vakje);
        queue.offer(root);
        while(!queue.isEmpty() && paqman == null){
            Node node = queue.poll();
            Vakje vakje = node.getData();
            checklist.add(vakje);
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
                        if(it.next().getData().equals(buurman.getValue())){
                            check = true;
                        }
                    }
                    if(!checklist.contains(buurman.getValue()) && !check){
                        Node child = new Node(buurman.getValue());
                        child.setParent(node);
                        queue.offer(child);
                    }
                }
            }
        }
        
        if(paqman == null){
            return getRandomNextVakje(spelelement.vakje);
        }else{
            return paqman.getNextNode().getData();
        }
    }
    
    private Vakje getRandomNextVakje(Vakje vakje){
            int windrichtingInt = new Random().nextInt(Windrichting.values().length);
            Windrichting windrichting = Windrichting.values()[windrichtingInt];
            HashMap<Windrichting, Vakje> buren = vakje.getBuren();
            if(buren.get(windrichting).getMuur()){
                return getRandomNextVakje(vakje);
            }else{
                return buren.get(windrichting);
            }
    }
}
