package spiel;

/**
 *
 * @author jbradley
 */
class Richtung {

    int deltaX;
    int deltaY;
    String bezeichnung;

    public Richtung(int deltaX, int deltaY, String bezeichnung) {

        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.bezeichnung = bezeichnung;

    }

    public Richtung(Position altePosition, Position neuePosition, String bezeichnung){

        this.deltaX = neuePosition.x - altePosition.x;
        this.deltaY = neuePosition.y - altePosition.y;
        
    }
    
    @Override
    public String toString() {
        return "Aktuelle Richtung: " + bezeichnung + "("+deltaX+","+deltaY+")";
    }

    
}
