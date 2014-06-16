/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;


/**
 *
 * @author Jerrold
 */
public class Level extends JPanel implements GameEventListener{

    private int level_nummer;
    private int aantalBolletjes;
    private int aantalBolletjesGegeten;
    
    private JLabel text;
    
    private Vakje[][] vakjes;
    private String[][] layout;
    private GameEventHandler gameEventHandler;

    /**
     * @param level_nummer Het nummer van het level wat ingeladen moet worden.
     * @param gameEventHandler Het centrale afhandelingspunt van game events welke gebruikt moet worden.
     *
     */
    public Level(int level_nummer, GameEventHandler gameEventHandler) {
        setBackground(Color.WHITE);
        this.level_nummer = level_nummer;
        aantalBolletjes = 0;
        aantalBolletjesGegeten = 0;
        setFocusable(true);
        requestFocus();
        text = new JLabel();
        this.gameEventHandler = gameEventHandler;
        gameEventHandler.addGameEventListener(this);
        init();
    }
    
    /**
     * De functie die alle vakjes,de bijbehorende elementen en de bijbehorende buren initialiseert.
     * Deze functie voegt tevens een Paqman als KeyListener toe aan het level.
     */
    private void init(){
        setLevel(level_nummer);
        this.vakjes = new Vakje[layout[0].length][layout.length];
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                vakjes[x][y] = new Vakje(x, y);
                switch(layout[y][x]){
                    case "m":
                        vakjes[x][y].setMuur(true);
                        break;
                    case "b": 
                        Bolletje bolletje = new Bolletje(vakjes[x][y], gameEventHandler);
                        vakjes[x][y].addElement(bolletje);
                        gameEventHandler.addGameEventListener(bolletje);
                        aantalBolletjes++;
                        break;
                    case "s":
                        Superbolletje superbolletje = new Superbolletje(vakjes[x][y], gameEventHandler);
                        vakjes[x][y].addElement(superbolletje);
                        gameEventHandler.addGameEventListener(superbolletje);
                        break;
                    case "p":
                        Paqman paqman = new Paqman(vakjes[x][y], gameEventHandler);
                        vakjes[x][y].addElement(paqman);
                        this.addKeyListener(paqman);
                        gameEventHandler.addGameEventListener(paqman);
                        break;
                    case "gd":
                        Spook spook = new Spook(vakjes[x][y], gameEventHandler, new BeweegDronken());
                        vakjes[x][y].addElement(spook);
                        gameEventHandler.addGameEventListener(spook);
                        break;
                    case "gs":
                        Spook slimSpook = new Spook(vakjes[x][y], gameEventHandler, new BeweegSlim());
                        vakjes[x][y].addElement(slimSpook);
                        gameEventHandler.addGameEventListener(slimSpook);
                        break;
                    default:
                        break;
                }
            }
        }
        setBuren();
        setLevelText("Level " + level_nummer);
    }
    
    public int getLevel(){
        return level_nummer;
    }
    
    /**
     * 
     * @param getal Het nummer van het level wat ingeladen moet worden.
     * De functie die het level inlaadt aan de hand van een tekstbestand. Het tekstbestand moet in de gamemap staan in de vorm \level_(nummer).txt.
     */
    private void setLevel(int getal){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("././src/projectpaqman/level_" + getal + ".txt"), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Kon het level niet inladen." + ex);
        }
        layout = new String[lines.size()][];
        lines.removeAll(Arrays.asList("", null)); // <- remove empty lines
        for(int i =0; i<lines.size(); i++){
            layout[i] = lines.get(i).split("[ ]+");
        }
    }
    
    /**
     * De functie waarmee de game na initialisatie daadwerkelijk gestart wordt.
     */
    private void startLevel(){
        requestFocus();
    }
    
    private void pauzeerLevel(){
        setLevelText("Gepauzeerd");
    }
    
    public String getLevelText(){
        return this.text.getText();
    }
    
    public void setLevelText(String tekst){
        if(tekst != null){
            gameEventHandler.gameEventOccurred(new GameEvent(GameEventType.TEXTTIMER));            
        }
        this.text.setText(tekst);
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
            Kers kers = new Kers(vakjes[(int)posX][(int)posY], gameEventHandler);
            vakjes[(int)posX][(int)posY].addElement(kers);
            gameEventHandler.setElementToAdd(kers);
        }else{
            spawnKers();
        }
    }
    
    /**
     * De functie waarmee een kers random op het veld gespawned kan worden.
     */
    public void spawnPowerup(){
        double posX = Math.random()*vakjes.length;
        double posY = Math.random()*vakjes[0].length;
        if(!vakjes[(int)posX][(int)posY].getMuur()){
            Powerup powerup = new Powerup(vakjes[(int)posX][(int)posY], gameEventHandler);
            vakjes[(int)posX][(int)posY].addElement(powerup);
            gameEventHandler.setElementToAdd(powerup);
        }else{
            spawnPowerup();
        }
    }
    
    /**
     * De functie waarmee een paqmanhelper random op het veld gespawned kan worden.
     */
    public void spawnPaqmanHelper(){
        double posX = Math.random()*vakjes.length;
        double posY = Math.random()*vakjes[0].length;
        if(!vakjes[(int)posX][(int)posY].getMuur()){
            PaqmanHelper paqmanHelper = new PaqmanHelper(vakjes[(int)posX][(int)posY], gameEventHandler);
            vakjes[(int)posX][(int)posY].addElement(paqmanHelper);
            gameEventHandler.setElementToAdd(paqmanHelper);
        }else{
            spawnPaqmanHelper();
        }
    }

    /**
     * De functie waarmee een paqmanhelper random op het veld gespawned kan worden.
     */
    private void setMurenLoper(boolean waarde){
        if(waarde){
            int aantalTransparanteMuren = 0;
            while(aantalTransparanteMuren<20){
                double posX = Math.random()*vakjes.length;
                double posY = Math.random()*vakjes[0].length;
                if(vakjes[(int)posX][(int)posY].getMuur() && !vakjes[(int)posX][(int)posY].getTransparent()){
                    if((int)posX != 0 && (int)posY != 0 && (int)posX != vakjes.length-1 && (int)posY != vakjes[0].length-1){
                        vakjes[(int)posX][(int)posY].setTransparent(true);
                        aantalTransparanteMuren++;
                    }
                }
            }
        }else{
            for (int x = 0; x < vakjes.length; x++) {
                for (int y = 0; y < vakjes[x].length; y++) {
                    vakjes[x][y].setTransparent(false);
                }
            }
        }
    }
    
    /**
     * De functie waarmee het level wordt beeïndigd.
     */
    public void delete(){
        try {
            gameEventHandler.clearGameEventListeners();
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
        
        if(text.getText() != null){
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font("Tahoma", Font.BOLD, 80));
            g.drawString(getLevelText(), 375, 375);
        }
    }

    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        switch(gameEvent.getEventType()){
            case START:
                startLevel();              
                break;
            case HERSTART:
                startLevel();
                break;
            case PAUZEER:
                pauzeerLevel();
                break;
            case TEXTTIMER:
                if(getLevelText() != null){
                    setLevelText(null);   
                }
                break;
            case POWERUP:
                if(gameEvent.getPowerup() != null && gameEvent.getPowerup().equals(Powerups.MURENLOPER)){
                    setMurenLoper(true);
                }else{
                    setMurenLoper(false);    
                }
                break;
            case EATBOLLETJE:
                aantalBolletjesGegeten++;
                
                //Kijk of de helft van alle bolletjes zijn opgegeten en spawn een kers, of dat alle bolletjes zijn opgegeten en start het nieuwe level.
                if(Math.round(aantalBolletjes/2) == aantalBolletjesGegeten){
                    spawnKers();
                }else if(aantalBolletjes == aantalBolletjesGegeten){
                    gameEventHandler.gameEventOccurred(new GameEvent(GameEventType.NEXTLEVEL));
                }
                break;
        }
        repaint();
    }
}
