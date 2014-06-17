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
public interface GameEventListener {

    /**
     * De functie die geimplementeerd moet worden, zodra een klasse deze interface implementeert. Via deze functie kunnen game events worden verstuurd.
     * @param gameEvent Het game event wat plaats heeft gevonden en wordt verspreid.
     */
    public void gameEventOccurred(GameEvent gameEvent);
}
