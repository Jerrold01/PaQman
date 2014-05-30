/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author Jerrold
 */
public class Level extends JPanel implements GameEventListener, ActionListener{

    private String naam;
    
    private int aantalBolletjes;
    private int aantalBolletjesGegeten;
    private Spelelement temporaryElement;
    private Timer timer = new Timer(500, this);
    private ArrayList<GameEventListener> gameEventListeners = new ArrayList();
    
    private Vakje[][] vakjes;
    private String[][] level_1 = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
        {"m", "p", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "m", "m", "m", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "b", "b", "m"},
        {"m", "x", "x", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m", "x", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "m", "m", "m", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m", "x", "b", "b", "m", "b", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "m", "m", "m", "m", "m", "m", "b", "m", "b", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "b", "b", "b", "b", "b", "m", "b", "m", "b", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "m", "m", "x", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "b", "gd", "m", "m", "m", "m", "m", "m", "m", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "b", "m", "x", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "b", "m"},
        {"m", "x", "b", "m", "x", "x", "x", "x", "b", "b", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "b", "m", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "b", "b", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "m", "x", "x", "x", "x", "x", "m", "x", "x", "b", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "m", "m", "m", "m", "m", "m", "m", "m", "s", "x", "x", "m", "m", "x", "m", "m", "x", "x", "m", "x", "x", "b", "m", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "x", "m", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "x", "b", "b", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "m", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "b", "b", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "b", "b", "x", "m", "x", "b", "x", "m", "m", "x", "x", "m", "m", "b", "m", "x", "x", "x", "m", "m", "m", "m", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "m", "b", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "gs", "x", "x", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "m", "b", "m", "x", "x", "x", "x", "x", "x", "b", "m", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "m", "m", "m", "m", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "b", "x", "x", "m", "x", "x", "x", "x", "b", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "b", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "m", "b", "b", "b", "b", "b", "m", "x", "m", "m", "m", "m", "m", "x", "x", "x", "b", "b", "b", "b", "b", "m", "x", "x", "m"},
        {"m", "x", "m", "x", "x", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "m", "m", "m", "m", "m", "x", "m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "m", "m", "m", "m", "m", "m", "x", "x", "m"},
        {"m", "x", "m", "m", "x", "x", "m", "x", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "x", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m", "x", "m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "b", "b", "b", "x", "m", "x", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "m"},
        {"m", "x", "b", "b", "b", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "m"},
        {"m", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "b", "b", "b", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"}                                             
    };

    /**
     * @param naam De naam van het level.
     * @param lengte De lengte in pixels x van het level.
     * @param breedte  De breedte in pixels y van het level.
     */
    public Level(String naam, int lengte, int breedte) {
        this.setBackground(Color.WHITE);
        this.naam = naam;
        this.vakjes = new Vakje[lengte / 25][breedte / 25];
        this.setFocusable(true);
        this.requestFocus();
        init();
    }
    
    /**
     * De functie die alle vakjes,de bijbehorende elementen en de bijbehorende buren initialiseert.
     * Deze functie voegt tevens een KeyListener toe aan Paqman.
     */
    private void init(){
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                vakjes[x][y] = new Vakje(x, y);
                switch(level_1[y][x]){
                    case "m":
                        vakjes[x][y].setMuur(true);
                        break;
                    case "b": 
                        Bolletje bolletje = new Bolletje(vakjes[x][y], this);
                        vakjes[x][y].addElement(bolletje);
                        gameEventListeners.add(bolletje);
                        aantalBolletjes++;
                        break;
                    case "s":
                        Superbolletje superbolletje = new Superbolletje(vakjes[x][y], this);
                        vakjes[x][y].addElement(superbolletje);
                        gameEventListeners.add(superbolletje);
                        break;
                    case "p":
                        Paqman paqman = new Paqman(vakjes[x][y], this);
                        vakjes[x][y].addElement(paqman);
                        this.addKeyListener(paqman);
                        gameEventListeners.add(paqman);
                        break;
                    case "gd":
                        Spook spook = new Spook(vakjes[x][y], this, new BeweegDronken());
                        vakjes[x][y].addElement(spook);
                        gameEventListeners.add(spook);
                        break;
                    case "gs":
                        Spook slimSpook = new Spook(vakjes[x][y], this, new BeweegSlim());
                        vakjes[x][y].addElement(slimSpook);
                        gameEventListeners.add(slimSpook);
                        break;
                    default:
                        break;
                }
            }
        }
        setBuren();
        timer.start();
    }
    
    public void addGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.add(gameEventListener);
    }
    
    /**
     * De functie waarmee alle buren van de vakjes, die binnen de constructor van klasse Level worden aangemaakt, worden meegegeven.
     */
    private void setBuren(){
        for(int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                //Als het vakje niet in de bovenste rij zit.
                if(y != 0){
                    vakjes[x][y].setBuren(Windrichting.NOORD, vakjes[x][y-1]);
                }
                
                //Als het vakje niet in de linkse kolom zit.
                if(x != 0){
                    vakjes[x][y].setBuren(Windrichting.WEST, vakjes[x-1][y]);
                }
                
                //Als het vakje niet in de rechtste kolom zit.
                if (x != vakjes.length-1){
                    vakjes[x][y].setBuren(Windrichting.OOST, vakjes[x+1][y]);
                }
                
                //Als het vakje niet in de onderste rij zit.
                if (y != vakjes[x].length-1) {
                    vakjes[x][y].setBuren(Windrichting.ZUID, vakjes[x][y+1]);
                }
            }
        }
    }
    
    /**
     * De functie waarmee een kers random op het veld gespawned kan worden.
     */
    private void spawnKers(){
        double posX = Math.random()*vakjes.length;
        double posY = Math.random()*vakjes[0].length;
        if(!vakjes[(int)posX][(int)posY].getMuur()){
            Kers kers = new Kers(vakjes[(int)posX][(int)posY], this);
            vakjes[(int)posX][(int)posY].addElement(kers);
            temporaryElement = kers;
        }else{
            spawnKers();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                vakjes[x][y].draw(g);
            }
        }
    }

    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case MOVE:
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.MOVE));
                }
                
                if(temporaryElement != null){
                    gameEventListeners.add(temporaryElement);
                    temporaryElement = null;
                }
                break;
            case EATBOLLETJE:
                aantalBolletjesGegeten++;
                if(Math.round(aantalBolletjes/2) == aantalBolletjesGegeten){
                    spawnKers();
                }else if(aantalBolletjes == aantalBolletjesGegeten){
                    //nextLevel();
                }
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.EATBOLLETJE));
                }
                break;
            case EATSUPERBOLLETJE:
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.EATSUPERBOLLETJE));
                }
                break;                
            case EATKERS:
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.EATKERS));
                }
                break;
            case DEAD:
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.DEAD));
                }
        }
        repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        for(GameEventListener gameEventListener: gameEventListeners){
            gameEventListener.gameEventOccurred(new GameEvent(EventType.TIMER));
            repaint();
        }
    }
}
