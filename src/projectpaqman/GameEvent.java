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
public class GameEvent{
    
    private boolean gepauzeerd;
    private boolean onverslaanbaar;
    private int aantal_levens;
    private int aantal_punten;
    
    GameEvent(){}
    
    GameEvent(boolean gepauzeerd, boolean onverslaanbaar, int aantal_levens, int aantal_punten){
        this.gepauzeerd = gepauzeerd;
        this.onverslaanbaar = onverslaanbaar;
        this.aantal_levens = aantal_levens;
        this.aantal_punten = aantal_punten;
    }
}
