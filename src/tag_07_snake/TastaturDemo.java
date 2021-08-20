package tag_07_snake;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author jbradley
 */
public class TastaturDemo extends JFrame {

    public TastaturDemo() throws HeadlessException {

        setTitle("Tastatur Demo");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()) {
                    case 37:
                        System.out.println("Left");
                        break;
                    case 38:
                        System.out.println("Up");
                        break;
                    case 39:
                        System.out.println("Right");
                        break;
                    case 40:
                        System.out.println("Down");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }

}
