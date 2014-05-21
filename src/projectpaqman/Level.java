/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpaqman;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jerrold
 */
public class Level extends JPanel {

    public Level() {

    }

    private String naam;
    private Vakje[][] vakjes;
    private String[][] layout = {
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"},
        {"m", "p", "x", "x", "x", "b", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "x", "m", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "s", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "x", "x", "x", "x", "x", "m", "b", "x", "x", "x", "m", "m", "m", "x", "x", "x", "x", "x", "m"},
        {"m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m", "m"}
    };

    public Level(String naam, int lengte, int breedte) {
        this.setBackground(Color.WHITE);
        this.naam = naam;
        this.vakjes = new Vakje[lengte / 30][breedte / 30];
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < vakjes.length; x++) {
            for (int y = 0; y < vakjes[x].length; y++) {
                System.out.println(x + " " + y + " " + layout[y][x]);
                switch (layout[y][x]) {
                    case ("m"):
                        vakjes[x][y] = new Vakje(g, x , y , layout[y][x]);
                        break;
                    case ("b"):
                        vakjes[x][y] = new Vakje(g, x, y, layout[y][x]);
                        break;
                    case ("s"):
                        vakjes[x][y] = new Vakje(g, x, y, layout[y][x]);
                        break;
                    default:
                        vakjes[x][y] = new Vakje(g, x, y, layout[y][x]);
                        break;
                }
            }
        }
    }
}
