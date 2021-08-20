/*
    Übungsaufgaben für FI AE 17 SS
    Kurs im November/Dezember/Januar 2017/18
    mit Harro Uwe Hieninger
*/

package spiel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author jbradley
 */
public class Steuerung extends KeyAdapter{

    final Richtung LEFT = new Richtung(-1, 0, "Left");
    final Richtung UP = new Richtung(0, -1, "Up");
    final Richtung RIGHT = new Richtung(1, 0, "Right");
    final Richtung DOWN = new Richtung(0, 1, "Down");
    Richtung richtung = LEFT;
    
    
    @Override
    public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case 37:
                        // System.out.println("Left");
                        if (richtung == RIGHT){
                            //skip
                        } else {
                        richtung = LEFT;
                        }
                        break;
                    case 38:
                        //System.out.println("Up");
                        if (richtung == DOWN){
                            //skip
                        } else {
                        richtung = UP;
                        }
                        break;
                    case 39:
                        //System.out.println("Right");
                        if (richtung == LEFT){
                            //skip
                        } else {
                        richtung = RIGHT;
                        }
                        break;
                    case 40:
                        //System.out.println("Down");
                        if (richtung == UP){
                            //skip
                        } else {
                        richtung = DOWN;
                        }
                        break;
                }
//                System.out.println(richtung);
    }
   

}
