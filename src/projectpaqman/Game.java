/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpaqman;

/**
 *
 * @author kevinwareman
 */
public class Game implements GameEventListener {
    
    private int aantal_levens;
    private int aantal_punten;
    private boolean onverslaanbaar;
    private boolean gepauzeerd;
    
    public static void main(String[] args) {
        Game game = new Game();
    }

    Game(){
        aantal_levens = 3;
        aantal_punten = 0;
        onverslaanbaar = false;
        gepauzeerd = false;
        createMainFrame();
    }
    
    private void createMainFrame(){
        MainFrame frame = new MainFrame(this);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
  
    public int getAantalLevens(){
        return aantal_levens;
    }
    
    public void setAantalLevens(int aantal_levens){
        this.aantal_levens = aantal_levens;
    }
    
    public int getAantalPunten(){
        return aantal_punten;
    }
    
    public void setAantalPunten(int aantal_punten){
        this.aantal_punten = aantal_punten;
    }
    
    public boolean getOnverslaanbaar(){
        return onverslaanbaar;
    }
    
    public void setOnverslaanbaar(boolean onverslaanbaar){
        this.onverslaanbaar = onverslaanbaar;
    }
    
    public boolean getGepauzeerd(){
        return gepauzeerd;
    }
    
    public void setGepauzeerd(boolean gepauzeerd){
        this.gepauzeerd = gepauzeerd;
    }
    
    @Override
    public void gameEventOccurred(GameEvent gameEvent){
        
    }
}
