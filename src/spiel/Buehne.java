/*
 Übungsaufgaben für FI AE 17 SS
 Kurs im November/Dezember/Januar 2017/18
 mit Harro Uwe Hieninger
 */
package spiel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class Buehne extends JPanel {

    char[][] LEVEL_1 = {{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x',}};
    char[][] LEVEL_2 = {
        {' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ',},
        {'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ',},
        {' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ',},
        {' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x',}
    };

    int BREITE = 30;
    int HOEHE = 20;
    Feld[][] felder;
    Steuerung steuerung;
    Timer timer;
//    ArrayList<Element> schlange;
    Schlange schlange;

    void nahrungAufstellen() {

        //Zufällig 5 Äpfel verteilen
        int zufallX;
        int zufallY;
        Nahrung nahrung;

        zufallX = (int) Math.floor(Math.random() * BREITE);
        zufallY = (int) Math.floor(Math.random() * HOEHE);
        if (felder[zufallY][zufallX].besetzt()) {
            nahrungAufstellen();
        } else {
            nahrung = new Nahrung(zufallX, zufallY);
            aufstellen(nahrung);
        }
//        for (int i = 0; i < 20; i++) {
//        zufallX = (int)Math.floor(Math.random() * BREITE);
//        zufallY = (int)Math.floor(Math.random() * HOEHE);
//        nahrung = new Nahrung(zufallX, zufallY);
//        aufstellen(nahrung);
//        }
    }

    void HindernisAufstellen(char[][] level) {

        for (int z = 0; z < level.length; z++) {
            for (int s = 0; s < level[z].length; s++) {
                if (level[z][s] == 'x') {
                    Hindernis h;
                    h = new Hindernis(s + 15, z + 15);
                    aufstellen(h);
                }
            }
        }
    }

    public Buehne() {

        setLayout(new GridLayout(HOEHE, BREITE));
        this.felder = new Feld[HOEHE][BREITE];
        for (int y = 0; y < HOEHE; y++) {
            for (int x = 0; x < BREITE; x++) {
                // einzeln Felder erzeugen und im Array speichern
                felder[y][x] = new Feld();
                // Felder auf die Bühne stellen
                add(felder[y][x]);
            }
        }

        setBackground(Color.BLUE);
//        demo();
        nahrungAufstellen();
//        HindernisAufstellen(LEVEL_2);
        steuerung = new Steuerung();
        addKeyListener(steuerung);
//        schlange = new Schlange(20, 15);
        schlange = new Schlange();
        schlange.add(new SchlangenElement(10, 10));
        schlange.add(new SchlangenElement(11, 10));
        schlange.add(new SchlangenElement(12, 10));
        aufstellen(schlange);
        spielen();
    }

    void aufstellen(Element element) {

        int x = element.position.x;
        int y = element.position.y;
//        if (felder[y][x].besetzt()) {
//            System.out.println("BESETZT");
//        } else {
        felder[y][x].add(element);
//        }
    }

    void aufstellen(ArrayList<Element> h) {

        for (Element next : h) {
            aufstellen(next);
        }
    }

    void aufstellen(Schlange s) {

        for (SchlangenElement e : s) {
            aufstellen(e);
        }
    }

    void demo() {

        Hindernis h = new Hindernis(10, 8);
        aufstellen(h);

        ArrayList<Element> balken_horizontal = new ArrayList<>();
        balken_horizontal.add(new Hindernis(2, 2));
        balken_horizontal.add(new Hindernis(3, 2));
        balken_horizontal.add(new Hindernis(4, 2));
        balken_horizontal.add(new Hindernis(5, 2));
        balken_horizontal.add(new Hindernis(6, 2));
        aufstellen(balken_horizontal);

        Nahrung n = new Nahrung(15, 20);
        aufstellen(n);

        SchlangenElement s = new SchlangenElement(13, 13);
        aufstellen(s);

        ArrayList<Element> riesenSchlange = new ArrayList<>();
//        riesenSchlange.add(new Schlange(20, 20));
//        riesenSchlange.add(new Schlange(20, 21));
//        riesenSchlange.add(new Schlange(21, 21));
//        riesenSchlange.add(new Schlange(21, 22));
//        riesenSchlange.add(new Schlange(22, 22));
//        riesenSchlange.add(new Schlange(22, 23));
//        riesenSchlange.add(new Schlange(23, 23));
//        aufstellen(riesenSchlange);

    }

    void spielen() {

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    //((SchlangenElement)schlange.get(0)).bewegen(steuerung.richtung);
                    schlange.bewegen(steuerung.richtung);
                    int kopfY = schlange.get(0).position.y;
                    int kopfX = schlange.get(0).position.x;
                    if (felder[kopfY][kopfX].istFutter()) {
                        System.out.println("Yummy");
                        felder[kopfY][kopfX].remove(0);
                        schlange.add(new SchlangenElement(
                                schlange.get(schlange.size() - 1).position.x,
                                schlange.get(schlange.size() - 1).position.y));
                        nahrungAufstellen();
                    }
                    if (felder[kopfY][kopfX].istHindernis()) {
                        System.out.println("Ouch");
                        timer.cancel();
                    }
                    if (felder[kopfY][kopfX].istSchlange()) {
                        System.out.println("Oh a snake");
                        timer.cancel();
                    }
                    aufstellen(schlange);
                    validate();
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.println("Ich warte");
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    System.out.println("OOPS!");
                    //timer.cancel();
                }
            }
        }, 1000, 100);
    }

}
