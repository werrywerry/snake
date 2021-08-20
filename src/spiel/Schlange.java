
package spiel;

import java.util.ArrayList;

/**
 *
 * @author jbradley
 */
public class Schlange extends ArrayList<SchlangenElement> {

    void bewegen(Richtung richtung){

        Richtung folgeRichtung;
        for (int n = this.size()-1; n > 0; n--) {
//            if(get(n-1).position == null){
//            folgeRichtung = new Richtung(0,0,"");
//            }
            folgeRichtung = new Richtung (get(n).position, get(n-1).position, "BERECHNET");
            get(n).bewegen(folgeRichtung);
        }
        
       SchlangenElement kopf = get(0);
       kopf.bewegen(richtung);
//       SchlangenElement ersterWirbel = get(1);
//       ersterWirbel.bewegen(richtung);
        
    }
    

}
