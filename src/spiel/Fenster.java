/*
    Übungsaufgaben für FI AE 17 SS
    Kurs im November/Dezember/Januar 2017/18
    mit Harro Uwe Hieninger
*/

package spiel;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author jbradley
 */
public class Fenster extends JFrame{
        Buehne buehne;

    public Fenster() throws HeadlessException {
        // sets window
        super("Snake");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // adds game field
        buehne = new Buehne();
        add(buehne);
        buehne.setFocusable(true);

        setVisible(true);
        
    }

    
    
}
