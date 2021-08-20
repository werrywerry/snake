/*
    Übungsaufgaben für FI AE 17 SS
    Kurs im November/Dezember/Januar 2017/18
    mit Harro Uwe Hieninger
*/

package spiel;

import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */

public class Element extends JPanel{
    
    Position position;

    public Element(int x, int y) {
        
        this.position = new Position(x, y);
        
    }

    public Element(){
        position = null;
    }
    
    public String getArt(){
        return "Element";
    }
    
}
