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
        Vakje nieuwVakje = nextVakjeDijkstra(spelelement);
        nieuwVakje.addElement(spelelement);
        spelelement.vakje.removeElement(spelelement);
        spelelement.vakje = nieuwVakje;
    }
    
    private Vakje nextVakje(Spelelement spelelement){
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
    
    /**
     * Functie om een willekeurig naastgelegen vakje van het ingevoerde vakje terug te krijgen. Dit vakje kan nooit een muur zijn.
     * @param vakje Het vakje waarvoor de functie een plaatsvervangend nieuw willekeurig vakje moet teruggeven.
     * @return Het eerstvolgende willekeurige vakje naast het ingevoerde vakje.
     */
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
    
    /**
     * Functie om het korste pad tot Paqman te berekenen a.d.h.v. het Dijkstra algoritme.
     * @param spelelement Spelelement om het eerstvolgende vakje tot Paqman voor te vinden.
     * @return Het eerstvolgende vakje waarnaar het ingevoerde spelelement moet lopen om dichterbij Paqman te komen.
     */
    private Vakje nextVakjeDijkstra(Spelelement spelelement){
        Vakje paqman = null;
        HashMap<Vakje, Integer> M = new HashMap(); //Vakjes met bijbehorende stappen tot de startcel.
        Queue<Vakje> Q = new LinkedList(); //De vakjes die nog gecheckt moeten worden in de wachtrij.
        ArrayList<Vakje> S = new ArrayList(); //Het definitieve kortste pad.
        HashMap<Vakje, Vakje> P = new HashMap(); //De vakjes met de voorganger.
        
        M.put(spelelement.vakje, 0);
        Q.offer(spelelement.vakje);
        while(!Q.isEmpty() && paqman == null){
            Vakje current = Q.poll();
            S.add(current);
            
            for(Spelelement element : current.getElementen()){
                if(element instanceof Paqman){
                    paqman = current;
                }
            }
            
            for(HashMap.Entry<Windrichting, Vakje> buurman : current.getBuren().entrySet()){
                if(!buurman.getValue().getMuur()){
                    if(!Q.contains(buurman.getValue())){
                        M.put(buurman.getValue(), M.get(current)+1);
                        Q.offer(buurman.getValue());
                        P.put(buurman.getValue(), current);
                    }
                }
            }
        }
        
        if(paqman == null){
            return getRandomNextVakje(spelelement.vakje);
        }else{
            Vakje nieuwVakje = paqman;
            for(int i=0; i < M.get(nieuwVakje)-1; i++){
                nieuwVakje = P.get(nieuwVakje);
            }
            return nieuwVakje;
        }
    }
}
