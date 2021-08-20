/*
    Übungsaufgaben für FI AE 17 SS
    Kurs im November/Dezember/Januar 2017/18
    mit Harro Uwe Hieninger
*/

package spiel;

import java.awt.Color;

/**
 *
 * @author jbradley
 */
public class Hindernis extends Element{
    final Color FARBE = Color.RED;

    public Hindernis(int x, int y) {
        super(x, y);
        setBackground(FARBE);
    }

    @Override
    public String getArt() {
        return "Hindernis";
    }
    
    

}
