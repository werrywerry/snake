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
public class Nahrung extends Element{

    final Color farbe = Color.GREEN;
    
    public Nahrung(int x, int y) {
        super(x, y);
        setBackground(farbe);
    }

        @Override
    public String getArt() {
        return "Nahrung";
    }

    
}
