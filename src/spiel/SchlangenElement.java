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
public class SchlangenElement extends Element {

    final Color farbe = Color.WHITE;

    public SchlangenElement(int x, int y) {
        super(x, y);
        setBackground(farbe);
    }

    public SchlangenElement(){
        this(0,0); // constructor Verkettung
        //position = null;
    }
    
    void bewegen(Richtung richtung) {
        position.x += richtung.deltaX;
        position.y += richtung.deltaY;
    }

    @Override
    public String getArt() {
        return "Schlange";
    }


}
