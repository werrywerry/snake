
package tag_07_snake;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jbradley
 */
class TimerDemo {

    void starten() {

        Timer timer = new Timer(); 
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("tick");
            }
        }, 500, 1000);
        
    }
    
    
}
