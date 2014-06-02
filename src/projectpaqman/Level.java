/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;


/**
 *
 * @author Jerrold
 */
public class Level extends JPanel implements GameEventListener, ActionListener{

    private int level_nummer;
    private int aantalBolletjes;
    private int aantalBolletjesGegeten;
    
    private Spelelement temporaryElement;
    private JLabel gametext;
    private Timer timer = new Timer(500, this);
    private Timer textTimer = new Timer(3000, this);
    
    private ArrayList<GameEventListener> gameEventListeners = new ArrayList();
    private Vakje[][] vakjes;
    private String[][] layout;
    
    /**
     * @param level_nummer Het nummer van het level wat ingeladen moet worden.
     * @param lengte De lengte in pixels x van het level.
     * @param breedte  De breedte in pixels y van het level.
     */
    public Level(int level_nummer, int lengte, int breedte) {
        this.setBackground(Color.WHITE);
        this.level_nummer = level_nummer;
        this.vakjes = new Vakje[lengte / 25][breedte / 25];
        this.setFocusable(true);
        this.requestFocus();
        this.gametext = new JLabel();
        init();
    }
    
    /**
     * De functie die alle vakjes,de bijbehorende elementen en de bijbehorende buren initialiseert.
     * Deze functie voegt tevens een KeyListener toe aan Paqman.
     */
    private void init(){
        setLevel(1);
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                vakjes[x][y] = new Vakje(x, y);
                switch(layout[y][x]){
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
        setGameText("Level " + level_nummer);
    }
    
    public int getLevel(){
        return level_nummer;
    }
    
    private void setLevel(int getal){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\Jerrold\\Documents\\NetBeansProjects\\Paqman\\src\\projectpaqman\\level_" + getal + ".txt"), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Kon het level niet inladen." + ex);
        }
        layout = new String[lines.size()][];
        lines.removeAll(Arrays.asList("", null)); // <- remove empty lines
        for(int i =0; i<lines.size(); i++){
            layout[i] = lines.get(i).split("[ ]+");
        }
    }
    
    public void addGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.add(gameEventListener);
    }
    
    public void removeGameEventListener(GameEventListener gameEventListener){
        gameEventListeners.remove(gameEventListener);
    }
    
    public String getGameText(){
        return this.gametext.getText();
    }
    
    public void setGameText(String tekst){
        this.gametext.setText(tekst);
        textTimer.start();
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
    
    public void delete(){
        try {
            this.finalize();
            System.out.println("Heeft het level afgesloten.");
        } catch (Throwable e){
            System.out.println("Kan het level niet afsluiten.");
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
        
        if(gametext.getText() != null){
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font("Tahoma", Font.BOLD, 80));
            g.drawString(getGameText(), 375, 375);
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
                for(GameEventListener gameEventListener: gameEventListeners){
                    gameEventListener.gameEventOccurred(new GameEvent(EventType.EATBOLLETJE));
                }
                
                //Kijk of de helft van alle bolletjes zijn opgegeten en spawn een kers, of dat alle bolletjes zijn opgegeten en start het nieuwe level.
                if(Math.round(aantalBolletjes/2) == aantalBolletjesGegeten){
                    spawnKers();
                }else if(aantalBolletjes == aantalBolletjesGegeten){
                    for(GameEventListener gameEventListener: gameEventListeners){
                        gameEventListener.gameEventOccurred(new GameEvent(EventType.NEXTLEVEL));
                    }
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
        if(actionEvent.getSource().equals(textTimer)){
            setGameText(null);
        }
        
        if(actionEvent.getSource().equals(timer)){
            for(GameEventListener gameEventListener: gameEventListeners){
                gameEventListener.gameEventOccurred(new GameEvent(EventType.TIMER));
                repaint();
            }
        }
    }
}
