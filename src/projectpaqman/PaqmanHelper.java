/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

import java.awt.*;
import java.util.*;

/**
 *
 * @author Kevin
 */
public class PaqmanHelper extends Spelelement {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public PaqmanHelper(Vakje vakje, GameEventListener gameEventListener){
        super(vakje, gameEventListener);
    }
    
    private void move(){
        Vakje nieuwVakje = nextVakje(this);
        nieuwVakje.addElement(this);
        this.vakje.removeElement(this);
        this.vakje = nieuwVakje;
    }
    
    private Vakje nextVakje(Spelelement spelelement){
        Node spook = null;
        Queue<Node> queue = new LinkedList();
        Node root = new Node(spelelement.vakje);
        queue.offer(root);
        while(!queue.isEmpty() && spook == null){
            Node node = queue.poll();
            Vakje vakje = node.getData();
            for(Spelelement element : vakje.getElementen()){
                if(element instanceof Spook){
                    spook = node;
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
        
        return spook.getNextNode().getData();
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);        
        g.fillRoundRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23, 20, 20);
        g.setColor(Color.YELLOW);
        g.drawRoundRect(vakje.getPosX()*25+1, vakje.getPosY()*25+1, 23, 23, 20, 20);
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        if(gameEvent.getEventType().equals(GameEventType.TIMER)){
            move();
        }
    }
}
