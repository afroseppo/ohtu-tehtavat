/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author tiitinha
 */
public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinenLasku = arvo(syotekentta);
        sovellus.nollaa();
        tuloskentta.setText("0");
        asetaNollausJaUndo(sovellus.tulos());
    }

    @Override
    public void peru() {
        if (edellinenLasku > 0) {
            sovellus.plus(edellinenLasku);
            tuloskentta.setText("" + sovellus.tulos());
        } else {
            sovellus.miinus(edellinenLasku);
            tuloskentta.setText("" + sovellus.tulos());
        }
        undo.disableProperty().set(true);
    }

}
