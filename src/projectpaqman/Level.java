/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import java.lang.reflect.Array;
import javax.swing.JPanel;

/**
 *
 * @author Jerrold
 */
public class Level extends JPanel {

    public Level() {

    }

    private String naam;
    private int lengte;
    private int breedte;
    private Vakje[][] vakjes;
    private String[][] layout = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "s", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "p", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"}
    };

    public Level(String naam, int breedte, int lengte) {
        this.setBackground(Color.WHITE);
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.vakjes = new Vakje[breedte / 30][lengte / 30];

//        for (int x = 0; x < vakjes.length; x++) {
//            for (int y = 0; y < vakjes[x].length; y++) {
//                vakjes[x][y] = new Vakje(true, x * 30, y * 30);
//            }
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                System.out.println(x + " " + y);
                switch (layout[y][x]) {
                    case ("m"):
                        vakjes[x][y] = new Vakje(g, x * 30, y * 30, Vakje.inhoudVakje.muur);
                        break;
                    case ("b"):
                        vakjes[x][y] = new Vakje(g, x * 30, y * 30, Vakje.inhoudVakje.bolletje);
                        break;
                    case ("s"):
                        vakjes[x][y] = new Vakje(g, x * 30, y * 30, Vakje.inhoudVakje.superbolletje);
                        break;
                    default:
                        vakjes[x][y] = new Vakje(g, x * 30, y * 30, Vakje.inhoudVakje.leeg);
                        break;
                }
            }
        }

//        for(int x=0; x < layout.length; x++){
//            for(int y=0; y < layout[x].length; y++){
//                switch(layout[x][y]){
//                    case("m"):
//                        vakjes[x][y].setMuur(true);
//                        break;
//                    case("b"):
//                        Bolletje b = new Bolletje();
//                        b.draw(g, x, y);
//                        break;
//                    case("s"):
//                        Superbolletje s = new Superbolletje();
//                        s.draw(g, x, y);
//                        break;
//                }
//            }
//        }
    }
}
