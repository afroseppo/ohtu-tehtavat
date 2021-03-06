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
public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinenLasku = arvo(syotekentta);
        int inputArvo = arvo(syotekentta);
        sovellus.plus(inputArvo);
        int laskunTulos = sovellus.tulos();
        tuloskentta.setText("" + laskunTulos);
        asetaNollausJaUndo(laskunTulos);
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinenLasku);
        tuloskentta.setText("" + sovellus.tulos());
        undo.disableProperty().set(true);
    }

}
