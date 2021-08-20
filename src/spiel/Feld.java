/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jbradley
 */
public class Feld extends JPanel{

    public Feld() {

        setLayout(new GridLayout(1, 1));
        setBackground(Color.DARK_GRAY);
        
    }
    
    boolean besetzt(){
        return getComponentCount() > 0;
    }
    
    boolean istFutter(){
        return ((getComponentCount()) > 0)
                && ((Element)getComponent(0)).getArt() == "Nahrung";
        
    }

    boolean istHindernis(){
        return ((getComponentCount()) > 0)
                && ((Element)getComponent(0)).getArt() == "Hindernis";
        
    }

    boolean istSchlange(){
        return ((getComponentCount()) > 0)
                && ((Element)getComponent(0)).getArt() == "Schlange";
    }

    @Override
    public Component add(Component comp) {
        if(getComponentCount() > 0) {

            return null;
        } else {
        return super.add(comp);
        }
    }

    

}
